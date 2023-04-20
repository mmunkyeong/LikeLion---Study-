import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<map.length; i++) {
            String s = br.readLine();
            for(int j=0; j<map[i].length; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        visited = new boolean[N][N];

        List<Integer> answer = new ArrayList<>();
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    answer.add(bfs(i, j));
                }
            }
        }

//        for(int i=0; i<map.length; i++) {
//            System.out.println(Arrays.toString(visited[i]));
//        }

        System.out.println(answer.size());
        Collections.sort(answer);
        for(int x : answer) {
            System.out.println(x);
        }
    }

    public static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        int count = 1;

        while(!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];

            for(int i=0; i<4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if(cx >= 0 && cy >= 0 && cx < N && cy < N) {
                    if(!visited[cx][cy] && map[cx][cy] == 1) {
                        queue.add(new int[]{cx, cy});
                        visited[cx][cy] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}