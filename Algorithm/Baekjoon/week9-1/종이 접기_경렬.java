import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<String> answer = new ArrayList<>();
    static String paper;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            paper = sc.nextLine();

            if (check(0, paper.length() - 1)) {
                answer.add("YES");
            } else {
                answer.add("NO");
            }
        }

        answer.forEach(System.out::println);
    }

    private static boolean check(int start, int end) {
        if (start == end) return true;

        int mid = (start + end) / 2;
        for (int i = start; i < mid; i++) {
            if (paper.charAt(i) == paper.charAt(end - i)) return false;
        }

        return check(start, mid - 1) && check(mid + 1, end);
    }
}