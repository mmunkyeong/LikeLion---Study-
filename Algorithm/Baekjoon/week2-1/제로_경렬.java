import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<size; i++) {
            int n = sc.nextInt();

            if(n == 0) {
                stack.pop();
            } else {
                stack.push(n);
            }
        }

        int sum = stack.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum);
    }
}
