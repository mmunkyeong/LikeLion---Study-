class Solution {
    public String solution(String s, int n) {
        char[] arr = s.toCharArray();

        for(int i=0; i<arr.length; i++) {
            if(arr[i] >= 65 && arr[i] <= 90) {
                arr[i] = (char) (arr[i] + n);
                if(arr[i] > 90) {
                    arr[i] = (char) (arr[i] - 26);
                }
            } else if(arr[i] >= 97 && arr[i] <= 122) {
                arr[i] = (char) (arr[i] + n);
                if(arr[i] > 122) {
                    arr[i] = (char) (arr[i] - 26);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }

        return String.valueOf(sb);
    }
}