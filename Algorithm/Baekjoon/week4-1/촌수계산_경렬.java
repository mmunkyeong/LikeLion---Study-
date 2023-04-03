import java.util.Scanner;

class Main {
    static boolean[] visited;
    static int[][] arr;
    static int result, pointCount, lineCount;
    static boolean find;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        pointCount = sc.nextInt();
        int start = sc.nextInt();
        int end = sc.nextInt();
        lineCount = sc.nextInt();

        arr = new int[pointCount+1][pointCount+1];
        visited = new boolean[pointCount+1];

        for(int i=0; i<lineCount; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(start, end, 0);

        if(!find) {
            result = -1;
        }
        System.out.println(result);
    }

    private static void dfs(int start, int end, int cnt) {
        visited[start] = true;

        if(start == end) {
            find = true;
            result = cnt;
            return;
        }

        for(int i=1; i<arr[start].length; i++) {
            if(arr[start][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, end, cnt+1);
                visited[i] = false;
            }
        }
    }
}