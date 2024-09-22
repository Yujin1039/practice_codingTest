import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cst = 1;
        
        for(;cst < n;cst++){
            String cstStr = cst + "";
            int cstSub = 0;
            for(int i=0;i<cstStr.length();i++){
                cstSub += cstStr.charAt(i) - 48;
            }
            if(n == cst+cstSub) break;
        }        
    	System.out.println(cst == n ? 0:cst);		            
	}
}