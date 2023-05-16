import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] s;
    static boolean[] check;
    static int result;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = new int[n][n];
        check = new boolean[n];

        // 입력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = sc.nextInt();
            }
        }

        result = Integer.MAX_VALUE;
        dfs(0, 0); // 함수호출
        System.out.println(result);
    }

    public static void dfs(int idx, int cnt) {
        //방문한 팀과 방문하지 않은 팀 각각 나누어 각 팀의 점수를 구해 최솟값 찾기
        if (cnt == n / 2) {
            cal();
            return;
        }

        // true일 경우 false일 경우 나눠짐
        for (int i = idx; i < n; i++) {
            if (check[i] == false) { // 방문하지 않은 경우
                check[i] = true; // 방문으로 변경
                dfs(i + 1, cnt + 1); // 재귀호출
                check[i] = false; // 재귀가 끝나면 다시 방문하지 않은 것으로 변경
            }
        }
    }

    public static void cal() {
        int start = 0;
        int link = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // true 인경우 스타트 팀으로 점수 더하기
                if (check[i] == true && check[j] == true) {
                    start += s[i][j];
                    start += s[j][i];
                } // false 인경우 링크팀으로 점수 더하기
                else if (check[i] == false && check[j] == false) {
                    link += s[i][j];
                    link += s[j][i];
                }
            }
        }
        // 두 팀의 점수차이
        int sub = Math.abs(start - link);

        // 백트래킹 부분
        // 두 팀의 차이가 0이면 가장 작은 최솟값이기 때문에 더 이상 탐색이 필요 없다.
        if (sub == 0) {
            System.out.println(sub);
            System.exit(0); // 0을 출력하고 exit로 끝내기
        }
        result = Math.min(result, sub);
    }
}
