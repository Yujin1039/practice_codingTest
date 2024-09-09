import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        char[][] letters = new char[5][15];
		
		for(int i=0;i<5;i++){
            letters[i] = br.readLine().toCharArray();
        }

        for(int x=0;x<15;x++){
            int len = sb.length();
            for(int y=0;y<5;y++){
                if(x < letters[y].length && letters[y][x] != 0) sb.append(letters[y][x]);                
            }
            if(len == sb.length()) break;
        }				
		System.out.println(sb);		
	}
}