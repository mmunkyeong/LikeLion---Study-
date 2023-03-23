import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        System.out.println(new Solution2().solution(13,17));
    }
}

class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for (int number = left; number <= right; number++) {
            int finalNumber = number;
            int count = (int)IntStream.range(1,finalNumber+1)
                    .filter(i -> finalNumber % i ==0)
                    .count();
            if(count % 2 ==0 ) answer +=number;
            else answer -= number;
        }

        return answer;
    }
}

class Solution2 {
    public int solution(int left, int right) {
        return IntStream.rangeClosed(left, right)
                .boxed()
                .collect(Collectors.partitioningBy(e -> yaksuCount(e) % 2 == 0, Collectors.summingInt(Integer::intValue)))
                .values()
                .stream()
                .reduce(0, (a, b) -> b - a);
    }

    private int yaksuCount(int number) {
        return (int) IntStream.rangeClosed(1, number)
                .filter(i -> number % i == 0)
                .count();
    }
}
