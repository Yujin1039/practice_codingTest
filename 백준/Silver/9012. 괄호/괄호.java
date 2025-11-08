import java.io.*;
import java.util.*;

public class Main { 
    static boolean isVPS(String str){
        Stack<Character> psStack = new Stack<>();
        for(int i=0;i<str.length();i++){
            char s = str.charAt(i);
            if(s == '('){
                psStack.add(s);
            }else{
                try {
                    psStack.pop();
                } catch (EmptyStackException e) {
                    return false;
                }
            }
        }
        return psStack.isEmpty();
    }
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());
        for(;a>0;a--){
            String str = br.readLine();
            sb.append(isVPS(str) ? "YES\n" : "NO\n");
        }        
        System.out.println(sb.toString());
	}    
}