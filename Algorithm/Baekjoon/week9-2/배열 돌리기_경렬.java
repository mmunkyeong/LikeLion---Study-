import java.util.*;

public class Main {

    static int T;
    static int size;
    static int angle;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();

        for(int i=0; i<T; i++) {
            size = sc.nextInt();
            angle = sc.nextInt();
            map = new int[size][size];
            for(int r=0; r<size; r++) {
                for(int c=0; c<size; c++) {
                    map[r][c] = sc.nextInt();
                }
            }

            if(angle < 0) angle += 360;

            size--;
            int num = 0;
            for(int j=0; j<angle/45; j++) {
                while(num < size/2) {
                    moveMap(num);
                    num++;
                }
                num = 0;
            }

            drawMap();

        }
    }

    private static void drawMap() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<map.length; i++) {
            for(int j=0; j<map[i].length; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    private static void moveMap(int num) {
        int temp = 0;
        temp = map[num][num];
        map[num][num] = map[size / 2][num];
        map[size / 2][num] = map[size - num][num];
        map[size - num][num] = map[size - num][size / 2];
        map[size - num][size / 2] = map[size - num][size - num];
        map[size - num][size - num] = map[size / 2][size - num];
        map[size / 2][size - num] = map[num][size - num];
        map[num][size - num] = map[num][size / 2];
        map[num][size / 2] = temp;
    }
}