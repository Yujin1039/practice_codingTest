import java.util.*;
import java.io.*;

public class Main {   
    public static String password(String psStr){
        List<Character> list = new LinkedList<>();
        ListIterator<Character> iter = list.listIterator();

        for(int i=0;i<psStr.length();i++){
            char s = psStr.charAt(i);
            if(s == '>'){
                if(iter.hasNext()) iter.next();
            }else if(s == '<'){
                if(iter.hasPrevious()) iter.previous(); 
            }else if(s == '-'){
                if(iter.hasPrevious()) {
                    iter.previous();
                    iter.remove(); 
                }
            }else{
                iter.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
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