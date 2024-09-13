import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int light = Integer.parseInt(st.nextToken());
        int night = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        
        int day = (int) Math.ceil((double) (h-night)/(light-night));       
		System.out.println(day);		
	}
}