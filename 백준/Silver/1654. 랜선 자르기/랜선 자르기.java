import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        int[] cable = new int[K];
        long end = 0;
        for(int i=0; i<K; i++){
            int lan = Integer.parseInt(br.readLine());
            cable[i] = lan;
            end += lan;
        }
        end /= N;
        
        long start = 1;
        while(start < end){
            long mid = start+(end-start+1)/2;            
            long num = 0;            
            for(int i=0; i<K; i++){
                num += cable[i]/mid;
            }            
            if(num >= N){
                start = mid;
            } else {
                end = mid-1;                
            }
        }
        System.out.println(start);
    }
}