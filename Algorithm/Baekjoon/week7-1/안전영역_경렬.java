import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;

    // 하, 우, 상, 좌
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0 , -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new int[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int max = 0;
        // 아무곳도 잠기지 않을 수 있기에 잠기는 물높이를 0부터 시작해서 최대 물높이 100까지 반복
        for(int i=0; i<=100; i++) {
            // 반복 때 마다 visited 배열을 초기화 해줘야함
            visited = new boolean[N][N];
            // 안전영역이 더 많은 것을 max에 저장
            max = Math.max(max, bfs(i));
        }

        System.out.println(max);
    }

    private static int bfs(int height) {
        int area = 0;

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                // 물 높이보다 작거나 같으면 침수니까 필요 없고, 이미 체크했던 곳이면 필요 없음
                if(map[i][j] <= height || visited[i][j]) continue;

                Queue<int[]> queue = new LinkedList<>();
                visited[i][j] = true;
                queue.add(new int[]{i, j});

                while(!queue.isEmpty()) {
                    int[] point = queue.poll();

                    for(int k=0; k<4; k++) {
                        int cx = point[0] + dx[k];
                        int cy = point[1] + dy[k];

                        // 범위를 벗어나면 다음
                        if(cx < 0 || cx >= N || cy <0 || cy >= N) continue;
                        // 바뀐 지점이 침수당할 높이거나, 이미 체크했던 곳이면 다음
                        if(map[cx][cy] <= height || visited[cx][cy]) continue;

                        visited[cx][cy] = true;
                        queue.add(new int[]{cx, cy});
                    }
                }

                area++;
            }
        }

        return area;
    }
}