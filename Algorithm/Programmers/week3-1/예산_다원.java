import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d); // 오름차순 정렬
        for(int i = 0; i < d.length; i++){
            budget = budget - d[i]; // 최대한 많은 부서 물품 구매하도록
            if(budget >= 0){
                answer += 1;
            }
            else{ // 예산 금액보다 크면 멈춤
                break;
            }
        }
        return answer;
    }
}