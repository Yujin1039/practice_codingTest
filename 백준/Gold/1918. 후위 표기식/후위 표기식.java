import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder postfixFm;
    private static Stack<Character> operator;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String formula = br.readLine();
        postfixFm = new StringBuilder();
        operator = new Stack<>();

        for(int i=0; i<formula.length();i++){
            char letter = formula.charAt(i);
            if(letter >= 'A' && letter <= 'Z'){
                postfixFm.append(letter);                
            } else if (letter == '(') {  
                operator.push('(');
            } else if (letter == ')') {  
                while (!operator.isEmpty() && operator.peek() != '(') {
                    postfixFm.append(operator.pop());                  
                } 
                if (!operator.isEmpty() && operator.peek() == '(') {
                    operator.pop();                
                }                
            } else {                
                while (!operator.isEmpty() && (getPriority(letter) <= getPriority(operator.peek()))) {
                    char oper = operator.pop();
                    postfixFm.append(oper);                   
                }
                operator.push(letter); //
            }
        }

        while (!operator.isEmpty()) {
            postfixFm.append(operator.pop());
        }
        System.out.println(postfixFm.toString());
    }

    private static int getPriority(char c){
        if(c == '*' || c == '/'){
            return 2;
        } else if(c == '+' || c == '-'){
            return 1;
        } if(c == '('){
            return 0;
        } 
        return -1;
    }
}