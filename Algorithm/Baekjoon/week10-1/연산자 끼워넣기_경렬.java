import java.util.*;

public class Main {
    static int N;
    static int[] nums;
    static int[] ops;
    static boolean[] visited;
    static int minResult = Integer.MAX_VALUE; // 최솟값을 저장할 변수. 초기값은 최대값으로 설정.
    static int maxResult = Integer.MIN_VALUE; // 최댓값을 저장할 변수. 초기값은 최소값으로 설정.

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];
        ops = new int[N-1]; // 연산자 개수는 숫자 개수보다 1 작음.
        visited = new boolean[N-1]; // 백트래킹에서 해당 연산자를 사용했는지 여부를 저장할 배열.

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt(); // 입력받은 숫자 저장.
        }

        int idx = 0;
        for (int i = 0; i < 4; i++) {
            int cnt = sc.nextInt();
            for (int j = 0; j < cnt; j++) {
                ops[idx++] = i; // 입력받은 연산자 저장. 연산자는 0부터 3까지의 정수로 저장됨.
            }
        }

        backtrack(nums[0], 0); // 첫번째 숫자와, 사용한 연산자의 개수 0으로 시작.

        System.out.println(maxResult); // 최댓값 출력.
        System.out.println(minResult); // 최솟값 출력.
    }

    static void backtrack(int result, int count) {
        if (count == N-1) { // 연산자를 모두 사용한 경우.
            minResult = Math.min(minResult, result); // 최솟값 갱신.
            maxResult = Math.max(maxResult, result); // 최댓값 갱신.
            return; // 백트래킹 종료.
        }

        for (int i = 0; i < N-1; i++) { // 연산자 개수만큼 반복.
            if (visited[i]) continue; // 이미 사용한 연산자인 경우 건너뜀.

            visited[i] = true; // 해당 연산자 사용 여부 표시.
            int next = nums[count+1]; // 다음 숫자 저장.

            switch (ops[i]) { // 해당 연산자에 따른 계산 수행.
                case 0:
                    backtrack(result + next, count + 1);
                    break;
                case 1:
                    backtrack(result - next, count + 1);
                    break;
                case 2:
                    backtrack(result * next, count + 1);
                    break;
                case 3:
                    backtrack(result / next, count + 1);
                    break;
            }

            visited[i] = false; // 해당 연산자 사용 여부 초기화.
        }
    }
}