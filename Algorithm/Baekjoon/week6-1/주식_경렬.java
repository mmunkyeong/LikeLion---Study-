import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int day = sc.nextInt();
            int[] cost = new int[day];
            for (int j = 0; j < cost.length; j++) {
                cost[j] = sc.nextInt();
            }

            int max = Integer.MIN_VALUE;
            long sum = 0;
            for (int j = day - 1; j >= 0; j--) {
                if (cost[j] > max) {
                    max = cost[j];
                } else {
                    sum += max - cost[j];
                }
            }
            System.out.println(sum);
        }
    }
}