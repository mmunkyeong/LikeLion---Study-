import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int marr[]=new int[n];

        for (int i = 0; i < n; i++) {
            int persons = sc.nextInt(); // 과목 신청자 수
            int limit = sc.nextInt(); // 과목당 수강인원
            Integer arr[] = new Integer[persons];

            for (int j = 0; j < persons; j++) {
                arr[j] = sc.nextInt();
            }

            if (persons < limit) { // 신청자수 보다 수강인원이 더 많다면
                marr[i]=1; // 1점 저장
            } else {
                Arrays.sort(arr, Collections.reverseOrder()); // 과목 내림차순
                marr[i] = arr[limit - 1]; // 수강인원 명수 만큼 마일리지 넣기
            }
        }

        Arrays.sort(marr); // 리스트 오름차순 정렬
        int sum=0;
        int cnt=0;
        for(int i=0; i<n; i++){
            sum+=marr[i]; // 마일리지의 합
            if(sum>m){
                break;
            } cnt++;
        }
        System.out.println(cnt);
    }
}
