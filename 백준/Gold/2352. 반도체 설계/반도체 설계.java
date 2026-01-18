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

        int[][] conNum = new int[n+1][2];
        conNum[1][1] = 1;
        for (int i=2; i<=n; i++) {
            conNum[i][0] = Math.max(conNum[i-1][0], conNum[i-1][1]);
            conNum[i][1] = 1;
            
            for(int j=i-1; j>0; j--) {
                if(pNum[j] < pNum[i]) {
                    conNum[i][1] = Math.max(conNum[j][1]+1, conNum[i][1]);  
                }
            }
        }
        System.out.println(Math.max(conNum[n][0], conNum[n][1]));
    }
}