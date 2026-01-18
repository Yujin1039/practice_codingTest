import java.util.*;
import java.io.*;

public class Main {    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] budget = new int[N];
        int min = 0; int max = 0;
        for(int i=0; i<N; i++){
            int bd = Integer.parseInt(br.readLine());
            budget[i] = bd;
            min = Math.max(min, bd);
            max += bd;
        }

        for(int i=0; i<N; i++){
            while(max > min){               
                int mid = (max+min+1)/2;

                int num = 0; int curBd = 0;
                for (int bd : budget) {
                    if(bd >= curBd){
                        num++;
                        curBd = mid;
                    }
                    curBd -= bd;
                }
                
                if(num > M){
                    min = mid;
                } else {
                    max = mid-1;
                }
            }
        }
        System.out.println(min);
    }
}