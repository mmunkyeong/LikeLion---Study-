class Solution {
   public int solution(int[] nums) {
        int answer = 0;
        int cnt=0;
        int sum=0;

        for(int i=0; i<nums.length-2; i++){
            for(int j=i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    sum=nums[i]+nums[j]+nums[k];
                    cnt=0;
                    
                    for(int h=1; h<=sum; h++){
                        if(sum%h==0)
                            cnt++;
                    }

                    if(cnt==2) answer++;
                }
            }
        }
        return answer;
    }
}
