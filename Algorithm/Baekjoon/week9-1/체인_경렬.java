import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        List<Integer> list = IntStream.range(0, N)
                .mapToObj(i -> sc.nextInt())
                .sorted()
                .collect(Collectors.toList());

        int count = 0;
        while (list.size() > 1) {
            list.set(0, list.get(0) - 1);
            list.remove(list.size() - 1);
            if (list.get(0) == 0) list.remove(0);
            count++;
        }

        System.out.println(count);
    }
}