import java.util.*;
import java.io.*;

public class Main {   
    public static String password(String psStr){
        ArrayDeque<Character> ps1 = new ArrayDeque<>();
        ArrayDeque<Character> ps2 = new ArrayDeque<>();

        for(int i=0;i<psStr.length();i++){
            char s = psStr.charAt(i);
            if(s == '>'){
                if(!ps2.isEmpty()) ps1.add(ps2.remove());
            }else if(s == '<'){
                if(!ps1.isEmpty()) ps2.addFirst(ps1.removeLast()); 
            }else if(s == '-'){
                if(!ps1.isEmpty()) ps1.removeLast();
            }else{
                ps1.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : ps1) {
            sb.append(c);
        }
        for (char c : ps2) {
            sb.append(c);
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(password(br.readLine())).append("\n");
        }
        
        System.out.println(sb);
    }
}