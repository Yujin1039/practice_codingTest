import java.io.*;
import java.util.*;

public class Main {      
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] seq = new int[n];
        for(int i=0;i<n;i++){
            seq[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(seq);
        
        int differ = 2000000000;
        int pre = 0;
        fin:
        for(int i=0;i<n;i++){
            int cur = seq[i];
            for(int j=pre;j<n;j++){
                int dif = seq[j] - cur;
                if(dif >= m){
                    differ = Math.min(dif,differ);
                    pre = j;
                    if(dif > m) break;
                    else break fin;
                }
            }
        }
        System.out.println(differ);
	}
}