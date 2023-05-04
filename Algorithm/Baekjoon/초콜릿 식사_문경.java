import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int size = 1;
        int result = 0;


        while (size < k) {
            size *= 2;
        }

        result = size; // 가장 작은 초콜릿 크기

        int cnt = 0;
        while (k>0) {
            if (k>=size) {
                 k-=size;
            } else {  // 초콜릿의 크기가 k보다 클 경우
                size /= 2; // 반으로 나누기
                cnt++;
            }
        }

        System.out.println(result + " " + cnt);
    }
}
