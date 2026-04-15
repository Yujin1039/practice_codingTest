import java.util.*;
import java.io.*;
import java.util.Collections.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] kid = new int[n];
        for(int i=0; i<n; i++){
            kid[i] = Integer.parseInt(br.readLine());
        }

        int[] lis = new int[n];
        lis[0] = kid[0];
        int idx = 1;
        for (int i=1; i<n; i++) {
            if(kid[i] > lis[idx-1]){
                lis[idx++] = kid[i];
            } else {
                int ins = Arrays.binarySearch(lis, 0, idx, kid[i]);

                if(ins < 0){
                    lis[-(ins+1)] = kid[i];
                } else {
                    lis[ins] = kid[i];
                }
            }
        }
        System.out.println(n-idx);
    }
}