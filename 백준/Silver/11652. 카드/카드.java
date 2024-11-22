import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        int max = 0;
        int idx = 0;
        int cur = 1;
        for(int i=1;i<n;i++){
            if(arr[i] == arr[i-1]) cur++;
            else {
                if(cur > max) {
                    max = cur;
                    idx = i-1;
                }
                cur = 1;
            }
        }
        if(cur > max) idx = n-1; 
        System.out.println(arr[idx]);
    }
}