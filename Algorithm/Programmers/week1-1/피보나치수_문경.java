class Solution {
    public int solution(int s) {
        int answer=0;
        int arr[]=new int[s+1]; 
// s가 2라고 치면 배열의 크기를 2로 하면 0,1만 들어가기 때문에 
// s+1 배열의 크기를 지정
        arr[0]=0; 
        arr[1]=1; 
        
        for(int i=2; i<=s; i++){ 
            arr[i]=(arr[i-1]+arr[i-2])%1234567; 
        }
        return arr[s]; 
    }
}
