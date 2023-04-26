import java.util.*;

/**
 * 5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
 * 4	[4,4,4,4,4]	[4,1,2,3]
 */
class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<>();
        for (int stage = 1; stage <= N; stage++) {
            int fail = 0;
            int comeToStage = 0;
            for (int i = 0; i < stages.length; i++) {
                if (stage == stages[i]) fail++;
                if (stage <= stages[i]) comeToStage++;
            }

            // 아무도 해당 스테이지에 오지 못했을 경우는 실패율을 0으로 한다.
            if(comeToStage == 0) {
                map.put(stage, 0.0);
            } else {
                map.put(stage, ((double) fail / comeToStage));
            }
        }

        System.out.println("저장된 map : " + map);

        // Map -> List 변환
        List<Map.Entry<Integer, Double>> list = new ArrayList<>(map.entrySet());
        System.out.println("정렬 전 List : " + list);

        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        System.out.println("정렬 후 List : " + list);

        // 정렬된 리스트에서 key를 가져와 순서대로 배열에 저장
        int[] answer = new int[N];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i).getKey();
        }

        System.out.println("실패율 기준 내림차순 된 스테이지 : " + Arrays.toString(answer));
        System.out.println();

        return answer;
    }

    public static void main(String[] args) {
        new Solution().solution(5, new int[]{2,1,2,6,2,4,3,3});
        new Solution().solution(4, new int[]{4,4,4,4,4});
        new Solution().solution(5, new int[]{4,4,4,4,4});
    }
}