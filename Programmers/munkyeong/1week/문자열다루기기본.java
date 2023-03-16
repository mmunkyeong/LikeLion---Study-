class Solution {
    public boolean solution(String s) {
       if(s.length()==4||s.length()==6){
        String str= s.replaceAll("[^0-9]","");
          if(s.equals(str)){
              return true;
          }
       }
        return false;
    }
}
