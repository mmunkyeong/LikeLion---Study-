import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long x = sc.nextLong();
        long y = sc.nextLong();
        long w = sc.nextLong();
        long s = sc.nextLong();

        // 모두 w 이동만 했을 경우
        long time1 = (x + y) * w;

        // 모두 s 이동만 했을 경우
        long time2 = Long.MAX_VALUE;
        if((x + y) % 2 == 0) {
            time2 = Math.max(x, y) * s;
        }

        // 한번만 w 이동하고 나머지는 s 이동 했을 경우
        long time3 = Long.MAX_VALUE;
        if((x + y) % 2 != 0) {
            time3 = w + (Math.max(x, y) - 1) * s;
        }

        // s 이동과 w 이동이 둘 다 있는 경우
        long time4 = (Math.min(x, y) * s) + (Math.abs(x - y) * w);

        // 모든 경우의 소요시간 중 가장 작은 것
        long result = Math.min(Math.min(time1, time2), Math.min(time3, time4));

        System.out.println(result);
    }
}