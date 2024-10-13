import java.io.*;
import java.util.*;

public class Main { 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringBuilder sb = new StringBuilder().append("<");
        
        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        Queue<Integer> circle = new LinkedList<>();
        for(int i = 1;i <= a;i++){
            circle.offer(i);
        }

        int b = Integer.parseInt(input[1]);
        int j = 0;
        int p = 1;
        while(!circle.isEmpty()){   
            int c = circle.poll();
            if(p != b){                
                circle.offer(c);
                p++;
            }else{
                sb.append(c).append(", ");
                p = 1;
            }
        }
        sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1).append(">");
        
        System.out.println(sb.toString());
	}    
}