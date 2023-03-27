import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int teamCount = sc.nextInt();
        int needTeams = sc.nextInt();
        int moreTeams = sc.nextInt();

        int[] arr = new int[teamCount];

        for(int i=0; i<needTeams; i++) {
            arr[sc.nextInt()-1]--;
        }

        for(int i=0; i<moreTeams; i++) {
            arr[sc.nextInt()-1]++;
        }

        int[] subArr1 = Arrays.copyOf(arr, arr.length);
        int[] subArr2 = Arrays.copyOf(arr, arr.length);


        for(int i=0; i<subArr1.length; i++) {
            if(subArr1[i] == 1 && i != subArr1.length-1) {
                if(subArr1[i+1] == -1) {
                    subArr1[i]--;
                    subArr1[i+1]++;
                }
            }
        }

        int answer1 = (int) Arrays.stream(subArr1)
                .filter(e -> e == -1)
                .count();

        for(int i=0; i<subArr2.length; i++) {
            if(subArr2[i] == 1 && i != 0) {
                if(subArr2[i-1] == -1) {
                    subArr2[i]--;
                    subArr2[i-1]++;
                }
            }
        }

        int answer2 = (int) Arrays.stream(subArr2)
                .filter(e -> e == -1)
                .count();

        System.out.println(Math.min(answer1, answer2));
    }
}