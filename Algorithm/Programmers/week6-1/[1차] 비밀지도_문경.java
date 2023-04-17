public class Solution {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int idx = 0;
        int length=0;
        for(int f=0; f<n; f++){ //배열 초기화 
            answer[f]="";
        }

        for (int i = 0; i < n; i++) {
            String st1 = Integer.toBinaryString(arr1[i]);
            String st2= Integer.toBinaryString(arr2[i]);

            if (st1.length() < n) { // 자리수가 n보다 작다면 
              length = n - st1.length(); // 채워야할 자리수
                st1 = binaryDigits(length, st1); //함수 호출
            }
            if (st2.length() < n) { 
                length = n - st2.length();
                st2 = binaryDigits(length, st2);
            }
            for (int j = 0; j < n; j++) {
                if (st1.charAt(j) == '1' || st2.charAt(j) == '1') { // 둘 중 하나라도 1이면 #
                    answer[idx] += "#";

                } else if (st1.charAt(j) == '0' && st2.charAt(j) == '0') { // 둘 다 0이면 공백
                    answer[idx] += " ";
                }
            }
            idx++;
        }
        return answer;
    }

    public static String binaryDigits(int cnt, String st) {
        String zero = "";
        for (int k = 0; k < cnt; k++) {
            zero += "0"; // 채워야할 자릿수 만큼 0더하기
        }
        st = zero + st; // 기존문자열 앞에 0붙여주기 
        return st;
    }
}
