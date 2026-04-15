import java.io.*;
import java.util.*;

public class Main { 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringBuilder sb = new StringBuilder();
        
        String pdStr = br.readLine();
        do{
            StringBuilder sbPd = new StringBuilder(pdStr);
            sb.append(sbPd.reverse().toString().equals(pdStr) ? "yes\n" : "no\n");
            pdStr = br.readLine();
        }while(!pdStr.equals("0"));
        
        System.out.println(sb.toString());
	}    
}