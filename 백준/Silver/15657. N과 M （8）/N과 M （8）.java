import java.io.*;
import java.util.*;

public class Main { 
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static int[] num;
    static int[] tmp;
    //                  (tmp 시작점,num 시작점)
    static void alignNum(int start,int cur){
        if(start == m){
            for(int a:tmp){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=cur;i<n;i++){
            tmp[start] = num[i];
            alignNum(start+1,cur);
            cur++;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n];
        tmp = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        
        alignNum(0,0);
        System.out.println(sb);
    }    
}