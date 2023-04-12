class Solution {
    public int solution(int n) {
        int answer = 0;
        String numStr="";
        int num=0;
        
        while(true){
            if(n<=0){
                break;
            }
            num=n%3;
            numStr+=String.valueOf(num);
            n/=3;
        }
        
        int idx=1;
        for(int i=numStr.length()-1; i>=0; i--){
            answer+= Character.getNumericValue(numStr.charAt(i))*idx;
            idx*=3;
        }
        return answer;
    }
}
