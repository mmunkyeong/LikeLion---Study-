import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
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