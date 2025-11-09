import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String origin = br.readLine();
        String explodeStr = br.readLine();
        char lastStr = explodeStr.charAt(explodeStr.length()-1);
        Stack<Character> stack = new Stack<>();
        Stack<Character> tempStr = new Stack<>();

        for(int i=0; i<origin.length();i++){
            stack.push(origin.charAt(i));
            
            if(origin.charAt(i) == lastStr) {
                if(stack.size() >= explodeStr.length()){
                    boolean isExplodeStr = true;
                    for(int j=explodeStr.length()-1; j>=0; j--){
                        if(stack.peek() == explodeStr.charAt(j)){
                            tempStr.push(stack.pop());
                        }else{
                            while(!tempStr.isEmpty()){
                                stack.push(tempStr.pop());
                            }
                            isExplodeStr = false;
                            break;
                        }
                    }
                    if(isExplodeStr) tempStr.clear();
                }
            }
        }
        System.out.println(stack.isEmpty()? "FRULA":stack.stream().map(String::valueOf).collect(Collectors.joining()));
    }
}