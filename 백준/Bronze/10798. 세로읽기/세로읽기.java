import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        String[] letters = new String[5];
        int max = 1;
		
		for(int i=0;i<5;i++){
            String word = br.readLine();
            letters[i] = word;
            if(word.length() > max) max = word.length();
        }

        for(int x=0;x<max;x++){
            for(int y=0;y<5;y++){
                try {
                    sb.append(letters[y].charAt(x)); 
                } catch (StringIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }				
		System.out.println(sb);		
	}
}