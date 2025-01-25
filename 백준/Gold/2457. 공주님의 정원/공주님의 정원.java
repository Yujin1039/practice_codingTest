import java.util.*;
import java.io.*;
import java.time.*;

public class Main {     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int n = Integer.parseInt(br.readLine()); 
        
        int[][] isBloom = new int[n][2]; 

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());

            int sIdx = LocalDate.of(2025,sm,sd).getDayOfYear()-1;
            int eIdx = LocalDate.of(2025,em,ed).getDayOfYear()-2;

            isBloom[i][0] = sIdx;
            isBloom[i][1] = eIdx;
        }
               
        int start = LocalDate.of(2025,3,1).getDayOfYear() -1;
        int end = LocalDate.of(2025,11,30).getDayOfYear() -1;
        int flowers = 0;

        for(int i=start;i<=end;i++){
            int num = 0;
            int max = 0;
            for(int j=0;j<n;j++){
                if(i >= isBloom[j][0] && i <= isBloom[j][1]) {
                    num++;
                    max = Math.max(max,isBloom[j][1]);
                }                
            }
            if(num == 0) {
                flowers = 0;
                break;
            }
            flowers++;
            i = max;
        }
        System.out.println(flowers);        
    }
}