package org.example;


import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    public static int MAX = Integer.MIN_VALUE;
    public static int MIN = Integer.MAX_VALUE;
    public static int[] oper = new int[4];
    public static int[] arr;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  // 숫자 입력
        }


        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken()); // 연산자 입력
        }

        dfs(arr[0], 1); // 함수 호출

        System.out.println(MAX); // 결과 출력
        System.out.println(MIN);

    }

    public static void dfs(int num, int idx) {
        if (idx == n) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (oper[i] >= 1) { // 연산자 개수가 1개 이상일 때
                oper[i]--; // 해당연산자 카운트 감소
                switch (i) {
                    case 0:
                        dfs(num + arr[idx], idx + 1);
                        break;
                    case 1:
                        dfs(num - arr[idx], idx + 1);
                        break;
                    case 2:
                        dfs(num * arr[idx], idx + 1);
                        break;
                    case 3:
                        dfs(num / arr[idx], idx + 1);
                        break;
                }
                oper[i]++; // 해당 연산자 개수 복구
            }
        }
    }
}
