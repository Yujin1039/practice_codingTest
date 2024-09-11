import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		String num = st.nextToken();
        int base = Integer.parseInt(st.nextToken());
        int n = 0;

        for(int i=0;i<num.length();i++){
            int a = 0;
            if(num.charAt(i) < 58){
                a = Character.getNumericValue(num.charAt(i));
            }else{
                a = (num.charAt(i)-55); 
            }
            n += a * Math.pow(base,num.length()-1-i);
        }        			
		System.out.println(n);		
	}
}