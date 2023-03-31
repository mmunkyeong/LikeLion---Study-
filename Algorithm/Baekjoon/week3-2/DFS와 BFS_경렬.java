import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static boolean[][] arr;
    static Queue<Integer> queue;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int node = sc.nextInt();
        int line = sc.nextInt();
        int start = sc.nextInt();

        arr = new boolean[node+1][node+1];
        visited = new boolean[node+1];

        for(int i=0; i<line; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a][b] = true;
            arr[b][a] = true;
        }

        dfs(start);
        System.out.println();

        queue = new LinkedList<>();
        visited = new boolean[node+1];

        bfs(start);
    }

    private static void bfs(int start) {
        queue.offer(start);

        visited[start] = true;

        while(!queue.isEmpty()) {
            start = queue.poll();

            System.out.print(start + " ");

            for(int i=1; i<arr[start].length; i++) {
                if(arr[start][i] && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

    private static void dfs(int start) {
        visited[start] = true;

        System.out.print(start + " ");

        for(int i=1; i<arr[start].length; i++) {
            if(arr[start][i] && !visited[i]) {
                dfs(i);
            }
        }
    }
}