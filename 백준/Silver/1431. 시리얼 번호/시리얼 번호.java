import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        LinkedList<String> dict = new LinkedList<>();
        for(int i=0;i<n;i++){
            dict.add(br.readLine());
        }

        Collections.sort(dict,(o1,o2)->{
            if(o1.length() != o2.length()) return o1.length()-o2.length();
            
            int num1 = 0; int num2 = 0;
            for(int i=0;i<o1.length();i++){
                char c = o1.charAt(i);
                if(c < 65) num1 += (int) c - 48;
            }
            for(int i=0;i<o2.length();i++){
                char c = o2.charAt(i);
                if(c < 65) num2 += (int) c - 48;
            }
            if(num1 != num2) return num1 - num2; 
            return o1.compareTo(o2);
        });

        StringBuilder sb = new StringBuilder();
        for(String s:dict){
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}