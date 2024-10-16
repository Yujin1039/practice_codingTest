import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> left = new ArrayDeque<>();
        ArrayDeque<String> right = new ArrayDeque<>();
        String str = br.readLine();
        for(int cur=0;cur<str.length();cur++){
            left.add(Character.toString(str.charAt(cur)));
        } 
        
        int n = Integer.parseInt(br.readLine());
        for(;n>0;n--){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("P")){
                left.add(st.nextToken());
            }else if(cmd.equals("L")){
                if(!left.isEmpty()) right.addFirst(left.removeLast());
            }else if(cmd.equals("D")){
                if(!right.isEmpty()) left.add(right.removeFirst());
            }else{
                if(!left.isEmpty()) left.removeLast();
            }
        }

        StringBuilder sb = new StringBuilder();
        for(String s:left){
            sb.append(s);
        }
        for(String s:right){
            sb.append(s);
        }
        System.out.println(sb);
        
    }
}