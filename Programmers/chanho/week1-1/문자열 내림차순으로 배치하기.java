import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            list.add((int) s.charAt(i));
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        for (int i = 0; i < list.size(); i++) {
            answer += (char) list.get(i).intValue();
        }
        
        return answer;
    }
}