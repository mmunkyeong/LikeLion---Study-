import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int subjectCount = sc.nextInt(); // 과목 수
        int mileage = sc.nextInt(); // 최대 마일리지

        // 각 과목마다 최소 필요 마일리지
        int[] eachMinMileage = new int[subjectCount];

        for (int i = 0; i < subjectCount; i++) {
            int apply = sc.nextInt(); // 지원자 수
            int max = sc.nextInt(); // 최대 수강인원 수

            // 각 지원자들의 사용 마일리지, 내림차순을 하기 위해 Integer 배열 선언
            Integer[] scores = new Integer[apply];
            for (int j = 0; j < apply; j++) {
                scores[j] = sc.nextInt();
            }

            // 내림차순 정렬
            Arrays.sort(scores, Collections.reverseOrder());

            // 최대 수강인원보다 지원자가 적으면 최소 필요 마일리지는 1이다.
            if (apply < max) {
                eachMinMileage[i] = 1;
                continue;
            }

            // 최소 필요 마일리지는 내림차순한 배열의 (최대 수강인원)번째 값
            eachMinMileage[i] = scores[max - 1];
        }

        // 모든 과목의 최소 필요 마일리지 배열을 오름차순 정렬
        Arrays.sort(eachMinMileage);

        int sum = 0;
        int count = 0;
        // 누적 합이 최대 마일리지보다 커지면 종료
        for (int x : eachMinMileage) {
            sum += x;
            if (sum > mileage) break;
            count++;
        }

        System.out.println(count);
    }
}