import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                for(int k=j+1; k<nums.length; k++) {
                    list.add(nums[i] + nums[j] + nums[k]);
                }
            }
        }

        return (int) list.stream()
                .filter(this::isPrime)
                .count();
    }

    public boolean isPrime(int num) {
        return IntStream.rangeClosed(1, num)
                .filter(e -> num % e == 0)
                .count() == 2;
    }
}