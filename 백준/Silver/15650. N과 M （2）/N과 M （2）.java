import java.util.*;
import java.io.*;

class Main { 
    static int n;
    static int m;
    static int[] seq;
    static boolean[] vis;
    static StringBuilder sb = new StringBuilder();
    
    static void subSeq(int cur,int start){
        if(cur == m){            
            for(int j=0;j<n;j++){
                if(vis[j]) sb.append(seq[j]).append(" ");
            }         
            sb.append("\n");
            return;
        }        
        for(int i=start-1;i<n;i++){
            if(!vis[i]){
                seq[i] = i+1;
                vis[i] = true;
                subSeq(cur+1,seq[i]);
                vis[i] = false;
            }            
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());        
        seq = new int[n];          
        vis = new boolean[n];

        subSeq(0,1);
        
        System.out.println(sb);
    }
}