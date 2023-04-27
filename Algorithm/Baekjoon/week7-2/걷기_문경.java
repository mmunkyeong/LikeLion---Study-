import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());
        long s = Long.parseLong(st.nextToken());

        long ds1, ds2, ds3;


        ds1 = (x + y) * w; // 수평 x,y 로만 이동

        if ((x + y) % 2 == 0) { // 짝수라면
            ds2 = Math.max(x, y) * s; // 대각선 이동
        } else {
            ds2 = (Math.max(x, y) - 1) * s + w; // 대각성이동, 수평이동 1칸
        }

        // 대각선으로 이동 후 수평이동
        ds3 = (Math.min(x, y)) * s + (Math.abs(x - y)) * w;

        // 가장 작은 값 출력
        System.out.println(Math.min(ds1, Math.min(ds2, ds3)));
    }
}
