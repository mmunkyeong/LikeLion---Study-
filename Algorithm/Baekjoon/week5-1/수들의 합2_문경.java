import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        int cnt = 0, start = 0,end=0;

        while(end<=n){
            if(sum==m){ //합이 m과 같다면 cnt 증가
                cnt++;
                sum-=arr[start++]; //값을 빼주고 start++

            }else if(sum<m){ //합이 m보다 작다면
                if(end==n) break; // end가 맨 끝이라면 끝내기
                sum+=arr[end++]; // 값을 더하고 end++

            }else{ //합이 m보다 크거나 같다면
                sum-=arr[start++];  //값을 빼주고 start++
            }
        }
        System.out.print(cnt);
    
