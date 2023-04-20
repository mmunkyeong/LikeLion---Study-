import java.util.*;

class Solution {
    public ArrayList solution(String[] name, int[] yearning, String[][] photo) {
        ArrayList<Integer> list=new ArrayList<>();
        
        
        for(int i=0; i<photo.length; i++){
            int result=0;
            for(int j=0; j<photo[i].length; j++){
                for(int k=0; k<name.length; k++){
                    if(photo[i][j].equals(name[k])){
                        result+=yearning[k];
                    }
                }
            }
            list.add(result);
        }
        
        return list;
    }
}
