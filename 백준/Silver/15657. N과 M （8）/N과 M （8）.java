import java.io.*;
import java.util.*;

public class Main { 
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int[] num;
    
    static void alignNum(int start,int[] tmp){
        if(start == m){
            for(int i=0;i<m;i++){
                sb.append(tmp[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int pre = start > 0 ? tmp[start-1]:tmp[0];
        for(int i=0;i<n;i++){
            if(num[i] >= pre){
                tmp[start] = num[i];
                alignNum(start+1,tmp);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];
        int[] tmp = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        
        alignNum(0,tmp);
        System.out.println(sb);
    }    
}