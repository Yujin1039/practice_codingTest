import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] range = new int[n][2];
        
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            range[i][0] = Integer.parseInt(st.nextToken());
            range[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(range,(o1,o2)->{
            if(o1[1] == o2[1]){
                return o1[0]-o2[0];
            }             
            return o1[1]-o2[1];
        });

        int cnt = 0;
        int end = 0;
        for(int i=0;i<n;i++){
            if(range[i][0] >= end){
                end = range[i][1];
                cnt++;
            }            
        } 
        System.out.println(cnt);
    }
}