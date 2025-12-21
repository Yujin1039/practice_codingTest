import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        char[][] cloud = new char[H][W];

        for(int i=0; i<H; i++){
            String line = br.readLine();
            for(int j=0; j<W; j++){
                cloud[i][j] = line.charAt(j);
            }
        }

        int[][] time = new int[H][W];
        for(int[] t:time){
            Arrays.fill(t,-1);
        }
        
        for(int i=0; i<H; i++){
            for(int j=0; j<W; j++){
                if(j>0 && time[i][j-1] > -1) time[i][j] = time[i][j-1]+1; 
                if(cloud[i][j] == 'c') time[i][j] = 0;
                
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int[] t:time){
            for(int n:t){
                sb.append(n+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}