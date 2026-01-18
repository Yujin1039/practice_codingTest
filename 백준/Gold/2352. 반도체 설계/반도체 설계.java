import java.util.*;
import java.io.*;

public class Main {    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] pNum = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            pNum[i] = Integer.parseInt(st.nextToken());
        }

        int[] conNum = new int[n+1];
        Arrays.fill(conNum, 1);
        for (int i=2; i<=n; i++) {            
            for(int j=i-1; j>0; j--) { 
                if(pNum[j] < pNum[i]) {
                    conNum[i] = Math.max(conNum[j]+1, conNum[i]);  
                }
            }
        }
        int ans = 0;
        for (int num : conNum) {
            ans = Math.max(num,ans);
        }
        System.out.println(ans);
    }
}