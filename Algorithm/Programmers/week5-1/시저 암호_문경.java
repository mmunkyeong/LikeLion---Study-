class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char str[]=new char[s.length()];
    
        for(int i=0; i<s.length(); i++){
            str[i]=s.charAt(i);
        }
        
        for(int i=0; i<str.length; i++){
            if(str[i]==' ') continue;
            
            for(int j=1; j<=n; j++){
                if(str[i]=='Z'){ // 대문자 Z라면 
                    str[i]='A'; // 대문자 A로
                    continue;
                } else if(str[i]=='z'){ //소문자 z라면
                    str[i]='a'; //대문자 a로 
                     continue;
                }
                str[i]=(char)(str[i]+1); //1씩 더하기(n만큼 반복)          
            }
        }
        
     for(int i=0; i<str.length; i++){
        answer+=Character.toString(str[i]); 
     }        
        return answer;
    }
}
