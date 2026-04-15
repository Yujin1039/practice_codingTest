import java.io.*;
import java.util.*;

public class Main {
    private static int recursionNum = 0;
    
    static int recursion(String s, int l, int r){
        recursionNum++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
        int a = Integer.parseInt(br.readLine());        
		for(;a>0;a--){
            String str = br.readLine();            
            bw.write(isPalindrome(str)+" "+recursionNum+"\n");
            recursionNum = 0;
        }
		bw.flush();
    	bw.close();
	}
}