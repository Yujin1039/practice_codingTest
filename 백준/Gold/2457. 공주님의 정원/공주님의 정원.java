import java.util.*;
import java.io.*;
import java.time.*;

public class Main {     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int n = Integer.parseInt(br.readLine()); 
        
        boolean[][] isBloom = new boolean[n][366];
        int[] duration = new int[n]; 

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());

            int sIdx = LocalDate.of(2025,sm,sd).getDayOfYear()-1;
            int eIdx = LocalDate.of(2025,em,ed).getDayOfYear()-1;

            for(int j=sIdx;j<eIdx;j++){
                isBloom[i][j] = true;
            }
            duration[i] = eIdx-1;
        }

        int start = LocalDate.of(2025,3,1).getDayOfYear() -1;
        int end = LocalDate.of(2025,11,30).getDayOfYear() -1;
        int flowers = 0;

        for(int i=start;i<=end;i++){
            int num = 0;
            int max = 0;
            for(int j=0;j<n;j++){
                if(isBloom[j][i]) {
                    num++;
                    max = Math.max(max,duration[j]);
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