class Solution {
    public String solution(String s) {
        String[] arr = s.split("");

        int subIndex = 0;
        for(int i=0; i<arr.length; i++) {
            if(subIndex % 2 == 0) {
                arr[i] = arr[i].toUpperCase();
            } else {
                arr[i] = arr[i].toLowerCase();
            }

            subIndex++;

            if(arr[i].equals(" ")) {
                subIndex = 0;
            }
        }

        return String.join("", arr);
    }
}