import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       String docs=br.readLine();
       String find=br.readLine();

       int result=0;
       String str = "";

       for(int i=0; i<docs.length(); i++){
           str+=docs.charAt(i);
           if(str.contains(find)) { //찾는 단어가 포함되어 있다면
               result++;  // 카운트 증가
               str = ""; // 초기화
           }
       }

        System.out.println(result);
    }
}
