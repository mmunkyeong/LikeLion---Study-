import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        List<double[]> fail=new ArrayList<>();
        double person=stages.length; // 도전자 수
        
        for(int i=1; i<=N; i++){
            int cnt=0;
            for(int j=0; j<stages.length; j++){
                if(i==stages[j]){ // 도전한 스테이지가 있다면
                    cnt++; // 카운트 증가
                }
            }
            if(cnt==0){ // 도전한 스테이지가 없을 경우
                fail.add(new double[]{i,0});
                continue;
            }
            fail.add(new double[]{i,cnt/person}); // 스테이지 번호 개수/ 도전한 사람
            person-=cnt; // 스테이지 번호 개수만큼 빼기
        }
        
        fail.sort((a,b)->Double.compare(b[1],a[1])); // 내림차순 정렬 
        
        for(int i=0; i<fail.size(); i++){
            answer[i]=(int)fail.get(i)[0]; // 해당 번호 출력
        } 
        
        return answer;
    }
}
