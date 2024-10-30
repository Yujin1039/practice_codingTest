 import java.util.*;
import java.io.*;

public class Main {
    static final int parenthesis = -1;
    static final int braket = -2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        Stack<Integer> stack = new Stack<>();
        boolean isRight = true;
        for(int i=0;i<arr.length;i++){
            char ch = arr[i];
            if(ch == '('){
                stack.add(parenthesis);
            }else if(ch == '['){
                stack.add(braket);
            }else if(ch == ')'){
                if(stack.isEmpty() || stack.peek() == braket){
                    isRight = false;
                    break;
                } 
                
                if(stack.peek() == parenthesis) {
                    stack.pop();
                    stack.add(2);
                }else {
                    int sub = 0;
                    while(!stack.isEmpty() && stack.peek() != parenthesis){
                        sub += stack.pop();
                        if(stack.isEmpty()) isRight = false;
                    }
                    if(isRight){
                        stack.pop();
                        sub *= 2;
                        stack.add(sub);
                    }                    
                }
            }else if(ch == ']'){
                if(stack.isEmpty() || stack.peek() == parenthesis) {
                    isRight = false;
                    break;
                } 
                
                if(stack.peek() == braket) {
                    stack.pop();
                    stack.add(3);
                }else {
                    int sub = 0;
                    while(!stack.isEmpty() && stack.peek() != braket){
                        sub += stack.pop();
                        if(stack.isEmpty()) isRight = false;
                    }
                    if(isRight){
                        stack.pop();
                        sub *= 3;
                        stack.add(sub);
                    }                    
                }
            }
        }
        
        int sum = 0;
        while(isRight && !stack.isEmpty()){
            int c = stack.pop();
            if(c < 0) {
                isRight = false;
                sum = 0;
            }else{
                sum += c;
            }
        }
        System.out.println(sum);
    }
}