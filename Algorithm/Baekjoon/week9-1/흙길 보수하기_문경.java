import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        int l=sc.nextInt();

        int arr[][]= new int[n][2];

        for(int i=0; i<n; i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){ // 시작위치가 같다면 끝위치 기준 오름차순
                    return Integer.compare(o1[1],o2[1]);
                }
                //시작위치 오름차순
                return Integer.compare(o1[0],o2[0]);
            }
        });


        int cnt=0;
        int range=0;

        for(int i=0; i<n; i++){
            if(arr[i][0]>range){ //시작위치가 범위보다 크다면
                range=arr[i][0];
            }
            if(arr[i][1]>=range){
                while(arr[i][1]>range){ // 끝위치가 범위보다 크다면
                    range+=l;
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
