import java.util.*;
import java.io.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int n = Integer.parseInt(br.readLine());
        int[] card = new int[n+1]; 
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=1;i<=n;i++){
            card[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] max = new int[n+1];
        max[1] = card[1];
        for(int i=2;i<=n;i++){
            for(int j=0;j<=i;j++){
                max[i] = Math.max(max[i],max[j]+card[i-j]);
            }
        }
        System.out.println(max[n]);
    }
}