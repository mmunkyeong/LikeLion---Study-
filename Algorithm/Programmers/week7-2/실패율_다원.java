import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            int fail = 0; // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수
            int all = 0; // 스테이지에 도달한 플레이어 수
            for (int j : stages) {
                if (j >= i) {
                    all++;
                    if (j == i) {
                        fail++;
                    }
                }
            }
            double per = (double) fail / all; // 실패율
            if(fail == 0 && all == 0) { // 모든 사람들이 시도조차 못한 스테이지가 있을 때는 0으로 처리 (0 / 0 = NaN 방지)
                per = 0;
            }
            map.put(i, per); // key: 스테이지, value: 실패율
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((value1, value2) -> (map.get(value2).compareTo(map.get(value1)))); // 실패율 기준 내림차순 정렬
        int[] answer = new int[list.size()]; // 내림차순 정렬한 key 값을 배열에 저장
        for (int i = 0; i < N; i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}