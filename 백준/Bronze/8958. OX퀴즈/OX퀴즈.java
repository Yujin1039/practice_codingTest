import java.io.*;
import java.util.*;

public class Main { 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringBuilder sb = new StringBuilder();
          
        int a = Integer.parseInt(br.readLine());
        for(int i=0;i<a;i++){
            String ox = br.readLine();
            int total = 0;
            int score = 0;
            for(int j=0;j<ox.length();j++){
                if(ox.charAt(j) == 'O'){
                    score++;
                }if(ox.charAt(j) == 'X'){
                    score = 0;
                }
                total += score;
            }
            sb.append(total).append("\n");
        }

        System.out.println(sb.toString());
	}    
}