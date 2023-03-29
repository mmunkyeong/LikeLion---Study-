import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int w=0;
        int h=0;  
        
      for(int i=0; i<sizes.length; i++){
          for(int j=0; j<sizes[0].length; j++){
              if(w<sizes[i][j]){
                  w=sizes[i][j]; // sizes 중 가장 큰 수 
              }
          }
      }
        
        for(int i=0; i<sizes.length; i++){
          int min=Math.min(sizes[i][0],sizes[i][1]); 
            if(h<min) h=min; // 작은 값들 중 가장 큰 수
        }
        return w*h;
    }
}
