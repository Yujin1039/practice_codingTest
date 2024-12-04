import java.io.*;
import java.util.*;

public class Main { 
    private static StringBuilder sb = new StringBuilder();
    private static int n;
    private static int m;
    private static int[] num;
    private static int[] tmp;

    static void alignNum(int start){
        if(start == m){            
            for(int a:tmp){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i=1;i<=n;i++){
            if(num[i] == num[i-1]) continue;
            tmp[start] = num[i];
            alignNum(start+1);            
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new int[n+1];
        tmp = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        alignNum(0);

        System.out.println(sb);
    }    
}