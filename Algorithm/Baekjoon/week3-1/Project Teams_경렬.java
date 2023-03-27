import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int team = sc.nextInt();
        int[] scores = new int[team * 2];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = sc.nextInt();
        }

        Arrays.sort(scores);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < team; i++) {
            int sum = scores[i] + scores[(team * 2) - (i + 1)];
            if (sum < min) {
                min = sum;
            }
        }

        System.out.println(min);
    }
}