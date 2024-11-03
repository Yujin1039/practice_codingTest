import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int m;
    static int[] ref;
    static boolean[] vis;
    static StringBuilder sb = new StringBuilder();

    public static void permuatation(int k) {
        if(k == m){
            for(int i=0;i<m;i++){
                sb.append(ref[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1;i<=n;i++){
            if(!vis[i-1]){
                ref[k] = i;
                vis[i-1] = true;
                permuatation(k+1);
                vis[i-1] = false;
            }
        }
        
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ref = new int[n];
        vis = new boolean[n];

        permuatation(0);
        System.out.println(sb);
    }
}