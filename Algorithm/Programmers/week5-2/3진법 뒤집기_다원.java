class Solution {
    public int solution(int n) {
        int answer = 0;
        String temp = Integer.toString(n, 3); // 10진법 -> 3진법
        String reverse = "";
        for (int i = temp.length() - 1; i >= 0; i--) { // 3진법 상에서 앞뒤 반전
            reverse = reverse + temp.charAt(i);
        }
        answer = Integer.parseInt(reverse, 3); // 반전한 3진법 -> 10진법
        return answer;
    }
}