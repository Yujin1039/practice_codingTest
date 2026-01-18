import java.util.*;
import java.io.*;

public class Main {    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] pNum = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            pNum[i] = Integer.parseInt(st.nextToken());
        }

        int[] conNum = new int[n];
        int idx = 1; 
        conNum[0] = pNum[0];

        for (int i=1; i<n; i++) {            
            if(conNum[idx-1] < pNum[i]){
                conNum[idx++] = pNum[i];
            } else {
                int mIdx = Arrays.binarySearch(conNum, 0, idx, pNum[i]);
                if(mIdx < 0){
                    mIdx = -(mIdx+1);                    
                }
                conNum[mIdx] = pNum[i];
            }
        }
        System.out.println(idx);
    }
}