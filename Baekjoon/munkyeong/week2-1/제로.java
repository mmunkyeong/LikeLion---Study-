import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack=new Stack<Integer>();

        int num=Integer.parseInt(br.readLine());

        for(int i=0; i<num; i++){
            int n=Integer.parseInt(br.readLine());
            if(n==0){
               stack.pop();
            }else {
                stack.add(n);
            }
        }
        int sum=0;
        for(int i=0; i<stack.size(); i++){
            sum+=stack.get(i);
        }
        System.out.println(sum);
    }
}
