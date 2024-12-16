import java.io.*;
import java.util.*;

public class Main {      
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[] tree = new int[t+1];
        int[][] plum = new int[t+1][w+1];
        for(int i=1;i<=t;i++){
            int n = Integer.parseInt(br.readLine());
            tree[i] = n;
            plum[i][0] = plum[i-1][0];
            if(n == 1) plum[i][0] += 1;            
        }

        plum[1][0] = (tree[1] == 1)? 1:0;
        plum[1][1] = 1 - plum[1][0];
        for(int i=2;i<=t;i++){
            int cur = tree[i];
            for(int j=1;j<=w;j++){
                if(cur == j%2+1) plum[i][j] = Math.max(plum[i-1][j]+1,plum[i-1][j-1]+1);
                else plum[i][j] = Math.max(plum[i-1][j],plum[i-1][j-1]);
            }            
        }

        int max = 0;
        for(int num:plum[t]){
            max = Math.max(max,num);
        }
        System.out.println(max);
	}
}