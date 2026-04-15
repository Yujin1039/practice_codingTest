import java.util.*;
import java.io.*;

public class Main {    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] box = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }

        int[] lis = new int[n];
        int idx = 1; 
        lis[0] = box[0];

        for (int i=1; i<n; i++) {            
            if(lis[idx-1] < box[i]){
                lis[idx++] = box[i];
            } else {
                int tmp = Arrays.binarySearch(lis, 0, idx, box[i]);

                if(tmp < 0) tmp = -(tmp+1);
                lis[tmp] = box[i];
            }
        }
        System.out.println(idx);
    }
}