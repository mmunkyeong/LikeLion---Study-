class Solution {
    public int solution(int[][] sizes) {
        int[][] copy = new int[sizes.length][sizes[0].length];

        for (int i = 0; i < sizes.length; i++) {
            copy[i][0] = Math.max(sizes[i][0], sizes[i][1]);
            copy[i][1] = Math.min(sizes[i][0], sizes[i][1]);
        }

        int maxA = Integer.MIN_VALUE;
        int maxB = Integer.MIN_VALUE;

        for(int i=0; i<copy.length; i++) {
            if(copy[i][0] > maxA) {
                maxA = copy[i][0];
            }
            if(copy[i][1] > maxB) {
                maxB = copy[i][1];
            }
        }

        return maxA * maxB;
    }
}