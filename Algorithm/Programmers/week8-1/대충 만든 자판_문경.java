    class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] answer = new int[targets.length];

            for(int i=0; i<targets.length; i++){

                for(int j=0; j<targets[i].length(); j++){

                    int idx=Integer.MAX_VALUE;

                    for(int k=0; k<keymap.length; k++){
                        int target=keymap[k].indexOf(targets[i].charAt(j));
                    
                        if(target!=-1 && idx>target){ // 해당 문자가 존재한다면 
                            idx=target; // 해당 문자의 위치 
                        }
                    }
                  
                    if(idx==Integer.MAX_VALUE){ // 존재하지 않는다면  
                        answer[i]=-1; 
                        break;
                    }else{
                        answer[i]+=idx+1; // 존재한다면 해당 문자의 위치 (0부터 시작하니+1) 더하기
                    }
                }
            }
            return answer;
        }
    }
