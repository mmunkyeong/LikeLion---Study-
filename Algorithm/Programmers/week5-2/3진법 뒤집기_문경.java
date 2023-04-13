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
            numStr+=String.valueOf(num);  //3으로 나눈 나머지를 numStr에 더하기 
            n/=3;
        }
        
        int idx=1; // 제곱수를 나타내는 변수 1, 3, 9, 27..
        for(int i=numStr.length()-1; i>=0; i--){
            answer+= Character.getNumericValue(numStr.charAt(i))*idx;
            idx*=3; 
        }
        return answer;
    }
}
