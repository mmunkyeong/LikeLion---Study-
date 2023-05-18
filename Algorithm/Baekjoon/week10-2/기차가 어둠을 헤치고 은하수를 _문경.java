import java.util.*;
import java.io.*;

public class Main {
    static int arr[][];
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][20];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int cmdNum = Integer.parseInt(st.nextToken()); // 명령번호
            int num = Integer.parseInt(st.nextToken()) - 1; // 기차번호

            // 명령어 번호 1, i번째 기차 x번째 좌석에 사람 태우기(이미 사람 있다면 안됨)
            if (cmdNum == 1) {
                int seatNum = Integer.parseInt(st.nextToken()) - 1;
                arr[num][seatNum] = 1;
            }
            // 명령어 번호 2, i번째 기차 x번째 좌석에 앉은 사람 하차 (사람 없다면 수행x)
            else if (cmdNum == 2) {
                int seatNum = Integer.parseInt(st.nextToken()) - 1;
                arr[num][seatNum] = 0;
            }
            // 명령어 번호 3, k번째 앉은 사람 => k+1번째로 모두 이동
            else if (cmdNum == 3) {
                for (int j = 18; j >= 0; j--) {
                    arr[num][j + 1] = arr[num][j];
                }
                arr[num][0] = 0;
            }
            // 명령어 번호 4, k번째 앉은 사람 => k-1번째로 모두 이동
            else if (cmdNum == 4) {
                for (int j = 1; j < 20; j++) {
                    arr[num][j - 1] = arr[num][j];
                }
                arr[num][19] = 0;
            }
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String s = Arrays.toString(arr[i]);
            set.add(s);
        }
        System.out.println(set.size());
    }
}
