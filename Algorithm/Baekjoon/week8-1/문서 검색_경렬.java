import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String main = sc.nextLine();
        String target = sc.nextLine();

        int count = 0;

        while(main.contains(target)) {
            count++;
            main = main.replaceFirst(target, "-");
        }

        System.out.println(count);
    }
}