import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
    
        Set<Integer> ab = new HashSet<>();
        int total = 0;
        for(int i = 0; i < 2; i++){                
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                total++;
                ab.add(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(ab.size()*2 - total);
	}
}