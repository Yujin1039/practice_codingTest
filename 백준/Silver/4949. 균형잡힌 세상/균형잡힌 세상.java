import java.util.*;
import java.io.*;

public class Main {
    public static String isBalance(String a){
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0;i<a.length();i++){
            char s = a.charAt(i);
            if(s == '(' || s == '['){
                stack.add(s);
            }else if(s == ')'){
                if(stack.isEmpty() || stack.removeLast() != '(') return "no";               
            }else if(s == ']'){
                if(stack.isEmpty() || stack.removeLast() != '[') return "no";
            }
        }
        return stack.isEmpty() ? "yes":"no";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        StringBuilder sb = new StringBuilder();
        while(!st.equals(".")){
            sb.append(isBalance(st)).append("\n");
            st = br.readLine();
        }
        System.out.println(sb);
    }
}