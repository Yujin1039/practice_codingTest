import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();        
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i=0; i<str.length(); i++){
            if(stack.size() < 3){
                stack.push(str.charAt(i));
            } else {
                stack.push(str.charAt(i));
                while (stack.size() >= 4) {
                    char l1 = stack.pop();
                    char l2 = stack.pop();
                    char l3 = stack.pop();
                    char l4 = stack.pop();
                  
                    if(l1 == 'P' && l2 == 'A' && l3 == 'P' && l4 == 'P'){
                        stack.push('P');
                    } else {
                        stack.push(l4);
                        stack.push(l3);
                        stack.push(l2);
                        stack.push(l1);
                        break;
                    }              
                }
            }
        }        
        System.out.println((stack.size() == 1 && stack.pop() == 'P') ? "PPAP":"NP");       
    }
}