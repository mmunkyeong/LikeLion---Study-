import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();
        int[][] arr = new int[N][2];
        for(int i=0; i<N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        Arrays.sort(arr, Comparator.comparingInt((int[] o) -> o[0]).thenComparing(o -> o[1]));

        int count = 0;
        int range = 0;
        for(int i=0; i<N; i++) {
            if(arr[i][0] > range) {
                range = arr[i][0];
            }

            while(arr[i][1] > range) {
                range += L;
                count++;
            }
        }

        System.out.println(count);
    }
}