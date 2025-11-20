import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i=0; i<N; i++){
            int tree = Integer.parseInt(st.nextToken());
            arr[i] = tree;
            max = tree > max ? tree:max;
        }

        int result = 0;
        int start = 0;
        int end = max;
        while(start <= end){
            int mid = start+(end-start)/2;
            long temp = 0;
            
            for(int i=0; i<N; i++){
                if(arr[i] > mid) temp += (long) (arr[i]-mid);
            }            
            if(temp >= M){
                start = mid+1;                
            } else {
                end = mid-1;
                result = end;
            }
        }
        System.out.println(result);
    }
}