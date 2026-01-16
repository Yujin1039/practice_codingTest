import java.util.*;
import java.io.*;

public class Main {    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] jewel = new int[M];
        int min = 1; int max = 0;
        for(int i=0; i<M; i++){
            int jw = Integer.parseInt(br.readLine());
            jewel[i] = jw;
            max = Math.max(jw, max);
        }
        
        while (max > min) {
            int mid = (max+min)/2;

            double people = 0;
            for(int jw: jewel){
                people += Math.ceil(jw/(double) mid);
            }
            if(people <= N){
                max = mid;
            } else {
                min = mid+1;
            }            
        }
        System.out.println(max);
    }
}