import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int N= Integer.parseInt(br.readLine());
        int col = 2;
        for(int i=1;i <= N;i++){
            col += col-1; 
        }
		System.out.println(col * col);		
	}
}