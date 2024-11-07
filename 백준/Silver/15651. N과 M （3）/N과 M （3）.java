import java.util.*;
import java.io.*;

class Main { 
    static int n;
    static int m;
    static int[] seq;
    static StringBuilder sb = new StringBuilder();
    
    static void subSeq(int cur){
        if(cur == m){            
            for(int j=0;j<m;j++){
                sb.append(seq[j]).append(" ");
            }         
            sb.append("\n");
            return;
        }        
        for(int i=0;i<n;i++){
            seq[cur] = i+1;
            subSeq(cur+1);            
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());        
        seq = new int[m];          

        subSeq(0);
        
        System.out.println(sb);
    }
}