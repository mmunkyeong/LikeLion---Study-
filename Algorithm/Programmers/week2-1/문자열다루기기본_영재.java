class Solution {
    public boolean solution(String s) {
        boolean answer = true;

        if (!(s.length() == 4 || s.length() == 6)) {
            return false;
        }

        char[] strToChars = s.toCharArray();

        for (char c : strToChars) {
            if (!Character.isDigit(c)) {
                return false;
            }
            if (Character.getNumericValue(c) >= 1 || Character.getNumericValue(c) <= 8) {
               continue;
            }
        }

        return answer;
    }
}
