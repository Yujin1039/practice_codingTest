import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] stick = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        stack.add('(');
        int pieces = 0;

        for(int i=1;i<stick.length;i++){
            if(stick[i] == ')'){
                stack.pop();
                if(stick[i-1] == '(') pieces += stack.size();
                else pieces++;
            }else{
                stack.add(stick[i]);
            }
        }
        System.out.println(pieces);
    }
}