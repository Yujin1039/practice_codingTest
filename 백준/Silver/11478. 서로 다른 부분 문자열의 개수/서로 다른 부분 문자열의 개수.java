import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Set<String> set = new HashSet<>();
    
        for(int i=0;i<=str.length();i++){
            for(int j=0;j<str.length()-i;j++){
                String sub_str = str.substring(j,j+1+i);
                if(!set.contains(sub_str)) set.add(sub_str);
            }
        }     
        System.out.println(set.size());
	}
}