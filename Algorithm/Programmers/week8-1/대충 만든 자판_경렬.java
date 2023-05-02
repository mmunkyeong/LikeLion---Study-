import java.util.Arrays;
import java.util.HashMap;

// ["ABACD", "BCEFD"]	["ABCD","AABB"]	  [9, 4]
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(String key : keymap) {
            for(int i=0; i<key.length(); i++) {
                char c = key.charAt(i);
                if(!map.containsKey(c) || i < map.get(c)) {
                    map.put(c, i + 1);
                }
            }
        }

        int[] result = new int[targets.length];
        for(int i=0; i<targets.length; i++) {
            int count = 0;
            for(int j=0; j<targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                if(map.containsKey(c)) {
                    count += map.get(c);
                } else {
                    count = 0;
                    break;
                }
            }
            result[i] = count == 0 ? -1 : count;
        }

        return result;
    }
}