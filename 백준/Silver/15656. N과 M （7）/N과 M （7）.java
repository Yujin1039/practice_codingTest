import java.io.*;
import java.util.*;

public class Main { 
    static int[] num;    
    static int m;
    static int[] tmp;
    static StringBuilder sb = new StringBuilder();
    
    static void makeSeq(int cnt){
        if(m == cnt) {
            for(int i=0;i<m;i++){
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i=0;i<num.length;i++){
            tmp[cnt] = num[i];
            makeSeq(cnt+1);
        }                
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        num = new int[n];
        tmp = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        
        makeSeq(0);
        
        System.out.println(sb);
    }
}