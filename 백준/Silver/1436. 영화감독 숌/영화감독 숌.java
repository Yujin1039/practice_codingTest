import java.io.*;
import java.util.*;

public class Main { 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int movieNum;
        int loop = 0;
        
        for(int i=666;;i++){
            if(String.valueOf(i).contains("666")) loop++;
            if(loop == N){
                movieNum = i;
                break;
            }
        }                          
        System.out.println(movieNum);
	}    
}