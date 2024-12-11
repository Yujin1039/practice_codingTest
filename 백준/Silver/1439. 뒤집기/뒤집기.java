import java.io.*;
import java.util.*;

public class Main {   
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int pre = str.charAt(0)-48;
        int zero = pre == 0 ? 1:0;
        int one = pre == 1 ? 1:0;
        
        for(int i=1;i<str.length();i++){
            int cur = str.charAt(i)-48;
            if(cur != pre){
                if(cur == 0) zero++;
                else one++;
                pre = cur;
            }
        }

        System.out.println(Math.min(zero,one));
	}
}