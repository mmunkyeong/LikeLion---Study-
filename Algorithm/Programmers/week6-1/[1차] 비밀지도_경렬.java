class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] nArr1 = new String[n];
        String[] nArr2 = new String[n];

        for(int i=0; i<arr1.length; i++) {
            String temp = Integer.toBinaryString(arr1[i]);
            while(temp.length() < n) {
                temp = "0" + temp;
            }
            nArr1[i] = temp;
        }

        for(int i=0; i<arr1.length; i++) {
            String temp = Integer.toBinaryString(arr2[i]);
            while(temp.length() < n) {
                temp = "0" + temp;
            }
            nArr2[i] = temp;
        }

        String[] answer = new String[n];
        for(int i=0; i<nArr1.length; i++) {
            String temp = "";
            for(int j=0; j<n; j++) {
                if(nArr1[i].charAt(j) == '1' || nArr2[i].charAt(j) == '1') {
                    temp += "#";
                } else {
                    temp += " ";
                }
            }
            answer[i] = temp;
        }

//        System.out.println(Arrays.toString(nArr1));
//        System.out.println(Arrays.toString(nArr2));
//        System.out.println(Arrays.toString(answer));

        return answer;
    }
}