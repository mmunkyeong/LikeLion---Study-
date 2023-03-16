import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Stack<String> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        String result = "";

        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            String arr[] = str.split(" ");

            if (arr[0].contains("push")) {
                stack.add(arr[1]);
            } else {
                if (arr[0].contains("top")) {
                    if (stack.isEmpty()) {
                        result = "-1";
                    } else {
                        result = stack.peek();
                    }
                } else if (arr[0].contains("size")) {
                    result = String.valueOf(stack.size());
                } else if (arr[0].contains("empty")) {
                    if (stack.isEmpty()) {
                        result = "1";
                    } else {
                        result = "0";
                    }
                } else if (arr[0].contains("pop")) {
                    if (stack.isEmpty()) {
                        result = "-1";
                    } else {
                        result = stack.pop();
                    }
                }
                System.out.println(result);
            }
        }
    }
}
