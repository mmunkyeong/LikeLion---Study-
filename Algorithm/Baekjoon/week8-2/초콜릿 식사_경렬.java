import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        // k가 이미 2의 제곱수라면 그대로 출력하고 종료
        for(int i=0; i<=20; i++) {
            if(k == (int) Math.pow(2, i)) {
                System.out.println(k);
                System.out.println(0);
                return;
            }
        }

        // 사야하는 초콜릿의 크기 구하기(max = 지수)
        int max = 1;
        for(int i=0; i<=20; i++) {
            if(k < (int) Math.pow(2, i)) {
                max = i;
                break;
            }
        }

        // 사야하는 초콜릿 크기
        System.out.println((int) Math.pow(2, max));

        // 자르는 횟수 구하기
        int count = 0;
        while(k != 0) {
            // 지수를 1씩 줄여가며 k에서 빼줌
            // 이때, k에서 반으로 자른 초콜릿을 뺀 값이 음수일 땐 빼면 안되고 count만 증가시켜야함
            int temp = (int) Math.pow(2, --max);
            if(k - temp >= 0) {
                k -= temp;
            }
            count++;
        }
        System.out.println(count);
    }
}