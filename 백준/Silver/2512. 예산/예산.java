import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] budget = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i=0; i<N; i++){
            int bd = Integer.parseInt(st.nextToken());
            max = Math.max(bd,max);
            budget[i] = bd;
        }
        Arrays.sort(budget);

        int total = Integer.parseInt(br.readLine());
        int min = 0;
        while (max > min) {
            int mid = (max+min+1)/2;
            long sum = 0;
            for (int bd : budget) {
                int cur_bd = Math.min(bd,mid);
                sum += cur_bd;
            }

            if(sum > total){
                max = mid-1;
            } else {
                min = mid;
            }
        }
        System.out.println(min);
    }
}