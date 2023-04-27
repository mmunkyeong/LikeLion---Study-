import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int dx[] =new int[]{0, 1, 0, -1}; // 상, 우, 하, 좌
    static int dy[]=new int[]{1, 0, -1, 0};
    static boolean visited[][];
    static int n,answer=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());


        map = new int[n+1][n+1];
        visited=new boolean[n+1][n+1];


        int max=0;
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max=Math.max(max,map[i][j]);
            }
        }

        for(int h=1; h<=max; h++) {
            int cnt = 0;

            visited=new boolean[n+1][n+1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (!visited[i][j] && map[i][j] >= h) {
                        cnt++;
                        dfs(i, j, h);
                    }
                }
            }
            answer=Math.max(answer,cnt);
        }
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int h){
        visited[x][y]=true;

        for(int i=0; i<dx.length; i++){
            int nx =x+dx[i];
            int ny=y+dy[i];

            if(nx<1||ny<1||nx>n||ny>n){
                continue;
            }

            if(!visited[nx][ny] && map[nx][ny]>=h){
                visited[nx][ny]=true;
                dfs(nx,ny,h);
            }
        }
    }
}
