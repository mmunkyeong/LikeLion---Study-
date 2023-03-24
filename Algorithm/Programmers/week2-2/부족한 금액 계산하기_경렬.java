import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public long solution(int price, int money, int count) {
        long answer = Arrays.stream(IntStream.rangeClosed(1, count)
                        .mapToLong(i -> (long) i * price)
                        .toArray())
                .sum() - money;

        if(answer <= 0) {
            return 0;
        }

        return answer;
    }
}