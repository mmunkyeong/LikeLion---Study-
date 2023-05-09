import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> list=new ArrayList<>();

        int n=sc.nextInt();

        for(int i=0; i<n; i++){
            String s=sc.next();

            if(s.length()==1){
                list.add("YES");
                continue;
            }
            list.add(check(s)); //함수 호출
        }

        for(int i=0; i<list.size(); i++){ //결과 출력
            System.out.println(list.get(i));
        }
    }

    public static String check(String s){
        int len=s.length();
        int idx=len/2;
        boolean stop=false;
        String result="";

        while(idx!=0){
            // 가운데 인덱스를 기준으로 처음 인덱스랑 마지막 인덱스 순차적으로 비교
            // 011 0 001 대칭의 합이 1이 되어야함, 011 가운데 1기준 0과 1합이 1
            for(int i=0, j=len-1; i<idx; i++,j--){
                if(s.charAt(i)==s.charAt(j)){ // 같다면 접을 수 없음
                    stop=true;
                    break;
                }
            }
            if(stop) break;
            len/=2; // 반으로 접어나가며 반복
            idx/=2;
        }
        return stop ? result="NO":"YES";
    }
}
