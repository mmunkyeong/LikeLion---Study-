import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);

        int cnt = 0;
        for(int x : d) {
            if(budget >= x) {
                budget -= x;
                cnt++;
            } else {
                break;
            }
        }

        return cnt;
    }
}