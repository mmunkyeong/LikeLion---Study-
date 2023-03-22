class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for (int i = left; i <= right; i++) {
            if (getPrimeCnt(i) % 2 == 0) {
                answer += i;
                continue;
            }
            answer -= i;
        }
        
        return answer;
    }
    
    static int getPrimeCnt(int n) {
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) cnt++;
        }

        return cnt;
    }
}