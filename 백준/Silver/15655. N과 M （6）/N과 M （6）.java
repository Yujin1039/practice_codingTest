import java.util.*;
import java.io.*;

class Main { 
    static int m;
    static int[] seq;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    
    static void subSeq(int cur,int start){
        if(cur == m){            
            for(int j=0;j<m;j++){
                sb.append(seq[j]).append(" ");
            }         
            sb.append("\n");
            return;
        }        
        for(int i=start;i<arr.length;i++){
            seq[cur] = arr[i];
            subSeq(cur+1,i+1);                       
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());        
        seq = new int[m];          

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        subSeq(0,0);
        
        System.out.println(sb);
    }
}