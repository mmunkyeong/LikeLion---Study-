import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int floor;
    static int start;
    static int end;
    static int up;
    static int down;
    static int[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        floor = sc.nextInt();
        start = sc.nextInt();
        end = sc.nextInt();
        up = sc.nextInt();
        down = sc.nextInt();
        visited = new int[floor + 1];

        bfs();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            if(current == end) System.out.println(visited[current]-1);

            if(current + up <= floor && visited[current + up] == 0) {
                visited[current + up] = visited[current] + 1;
                queue.add(current + up);
            }

            if(current - down > 0 && visited[current - down] == 0) {
                visited[current - down] = visited[current] + 1;
                queue.add(current - down);
            }
        }

        if(visited[end] == 0) {
            System.out.println("use the stairs");
        }

//        System.out.println(Arrays.toString(visited));
    }
}