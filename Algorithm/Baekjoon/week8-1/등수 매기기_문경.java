import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        long arr[]=new long[n];
        long result=0;

        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }

        Arrays.sort(arr); // 오름차순 정렬


        for(int i=0; i<n; i++){
           if(arr[i]!=i+1) result+=Math.abs(arr[i]-(i+1)); // 해당 순위가 아니라면 예상순위-현재순위 
        }

        System.out.println(result);
    }
}
