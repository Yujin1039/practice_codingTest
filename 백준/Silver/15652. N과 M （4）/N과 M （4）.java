import java.util.*;
import java.io.*;

class Main { 
    static int n;
    static int m;
    static int[] seq;
    static StringBuilder sb = new StringBuilder();
    
    static void subSeq(int cur,int start){
        if(cur == m){            
            for(int j=0;j<m;j++){
                sb.append(seq[j]).append(" ");
            }         
            sb.append("\n");
            return;
        }        
        for(int i=1;i<=n;i++){
            if(i >= start){
                seq[cur] = i;
                subSeq(cur+1,seq[cur]);
            }                        
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());        
        seq = new int[m];          

        subSeq(0,1);
        
        System.out.println(sb);
    }
}