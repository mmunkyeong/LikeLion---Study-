class Solution {
    public String solution(String s) {
        String answer = "";
        String str[]=s.split("");
        int cnt=0;
        
        for(int i=0; i<str.length; i++){
            if(!str[i].equals(" ")){ //공백이 아니라면 
                   if(cnt%2==0){ 
                    answer+=str[i].toUpperCase(); 
                }else{ 
                    answer+=str[i].toLowerCase();
                }
                 cnt++;
            }else{
                answer+=str[i];
                cnt=0; //공백이라면 cnt=0으로 초기화
            }
        }
        
        return answer;
    }
}
