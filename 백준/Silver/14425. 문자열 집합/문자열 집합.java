import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());                
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String,Integer> check = new TreeMap<>();
        for(int i = 0; i<n; i++){
            check.put(br.readLine(),1);
        }

        int contain = 0;
        for(int i = 0;i<m;i++){
            int ch = check.get(br.readLine()) != null ? 1:0;
            if(ch == 1) contain++;
        }

        System.out.println(contain);
	}
}