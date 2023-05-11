import java.util.*;
import java.io.*;

public class Main {
    static int n, d;
    static int arr[][];
    static int result[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            if (d < 0) d += 360; //음수라면 해당 값에서 360 더하기
            d /= 45; // 나누어서 d만큼만 배열 돌리기

            arr = new int[n][n];
            result = new int[n][n];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                    result[j][k] = arr[j][k]; // 배열복사
                }
            }

            while (d > 0) {
                for (int j = 0; j < n; j++) {
                    result[j][n / 2] = arr[j][j]; // 0,2부터 배열 돌리기 0,2=0,0
                    result[j][j] = arr[n / 2][j]; // 0,0 =2,0
                    result[n / 2][j] = arr[n - j - 1][j]; // 2,0 =4,0
                    result[n - j - 1][j] = arr[n - j - 1][n / 2]; //  4,0=4,2
                }
                d--; //한 번 수행했으니 카운트 감소

                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        arr[k][l] = result[k][l]; //배열 복사
                    }
                }
            }
            for (int[] res : arr) {
                for (int a : res)
                    sb.append(a + " ");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}

