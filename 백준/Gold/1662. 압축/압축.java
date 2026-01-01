import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int len = 0;

        for(int i=0; i<str.length(); i++){
            Character ch = str.charAt(i);
            if(ch == ')'){
                int cur = 0;                
                while (!stack.isEmpty() && stack.peek() != -1) {
                    cur += stack.pop();
                }
                stack.pop();
                cur *= stack.pop();
                stack.push(cur);
                
            } else if(ch == '(') {
                stack.push(-1);                     
            } else {
                if(i < str.length()-1 && str.charAt(i+1) == '(') stack.push(ch-'0');
                else stack.push(1);
            }
        }
        
        while(!stack.isEmpty()){
            len += stack.pop();
        }         
        
        System.out.println(len);       
    }
}