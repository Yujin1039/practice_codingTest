import java.io.*;
import java.util.*;

public class Main { 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringBuilder sb = new StringBuilder();

        int entry = Integer.parseInt(br.readLine());        
        StringTokenizer st1 = new StringTokenizer(br.readLine()); 
        
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        double shirt = Double.parseDouble(st2.nextToken());
        int pen = Integer.parseInt(st2.nextToken());
        
        int sBundle = 0;        
        for(int i=0;i<6;i++){
             sBundle += Math.ceil(Integer.parseInt(st1.nextToken())/shirt);
        }
        sb.append(sBundle).append("\n").append(entry/pen).append(" ").append(entry%pen);
        
        System.out.println(sb.toString());
	}    
}