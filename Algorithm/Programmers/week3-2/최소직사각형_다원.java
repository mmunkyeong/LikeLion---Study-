class Solution {
    public int solution(int[][] sizes) {
        int x = 0; // 가로
        int y = 0; // 세로

        for(int i = 0; i < sizes.length; i++){
            int max = Math.max(sizes[i][0], sizes[i][1]); // 가로, 세로 중 큰 수 선택
            int min = Math.min(sizes[i][0], sizes[i][1]); // 가로, 세로 중 작은 수 선택

            if(max > x) { // 선택한 큰 수 중 가장 큰 수를 max로
                x = max;
            }
            if(min > y) { // 선택한 작은 수 중 가장 큰 수를 min으로
                y = min;
            }
        }
        int answer = x * y;
        return answer;
    }
}