import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            long arr[] = new long[n];
            long result = 0;
            long max = 0;

            for (int k = 0; k < n; k++) {
                arr[k] = Integer.parseInt(st.nextToken());
            }
            for (int j = n - 1; j >= 0; j--) { // 마지막 값 부터 비교
                if (arr[j] > max) {
                    max = arr[j];
                } else {
                    result += (max - arr[j]); //비싼가격 - 현재 가격한 값 result에 더하기
                }
            }
            System.out.println(result);
        }
    }
}
