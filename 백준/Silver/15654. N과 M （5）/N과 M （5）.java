import java.util.*;
import java.io.*;

class Main { 
    static int m;
    static int[] seq;
    static int[] arr;
    static boolean[] vis;
    static StringBuilder sb = new StringBuilder();
    
    static void subSeq(int cur){
        if(cur == m){            
            for(int j=0;j<m;j++){
                sb.append(seq[j]).append(" ");
            }         
            sb.append("\n");
            return;
        }        
        for(int i=0;i<arr.length;i++){
            if(!vis[i]){
                vis[i] = true;
                seq[cur] = arr[i];
                subSeq(cur+1);
                vis[i] = false;
            }                        
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());        
        seq = new int[m];          

        vis = new boolean[n];
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        subSeq(0);
        
        System.out.println(sb);
    }
}