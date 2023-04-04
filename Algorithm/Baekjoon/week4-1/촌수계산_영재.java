import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[] visited;
    static List<Integer>[] relations;
    static int level = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.valueOf(st.nextToken());
        int B = Integer.valueOf(st.nextToken());

        int m = Integer.valueOf(br.readLine());

        relations = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            relations[i] = new ArrayList<>();
        }
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int num1 = Integer.valueOf(st.nextToken());
            int num2 = Integer.valueOf(st.nextToken());

            relations[num1 - 1].add(num2 - 1);
            relations[num2 - 1].add(num1 - 1);
        }

        dfs(A - 1, B - 1, 0);

        System.out.println(level);
    }

    static void dfs(int start, int end, int cnt) {
        if (start == end) {
            level = cnt;
            return;
        }

        visited[start] = true; // 방문처리
        for (int i = 0; i < relations[start].size(); i++) {
            int temp = relations[start].get(i);
            if (!visited[temp]){
                dfs(temp, end, cnt + 1);
            }
        }
    }
}
