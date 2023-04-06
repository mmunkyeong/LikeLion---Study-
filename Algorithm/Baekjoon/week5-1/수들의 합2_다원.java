import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n]; // 수열을 담을 배열
        int count = 0;
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < n; i++){
            int sum = arr[i];
            if(arr[i] == m){ // i번째 수부터 j번째 수까지 합이 아닌 자기 자신이 m일때
                count++;
            }
            for(int j = i + 1; j < n; j++){
                sum += arr[j];
                if(sum == m){ // i번째 수부터 j번째 수까지 합이 m일때
                    count++;
                    break;
                }
                else if(sum > m){ // 합이 m보다 커지면 더 찾아볼 이유가 없으므로 break
                    break;
                }
            }
        }
        System.out.println(count);
    }
}