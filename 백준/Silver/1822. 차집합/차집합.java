import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int[] b = new int[m];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b);
        
        int cnt = 0; int start = 0;
        StringBuilder sb = new StringBuilder();
        for(int j=0;j<n;j++){
            int idx = Arrays.binarySearch(b,start,m,a[j]);
            if(idx < 0){
                cnt++;
                sb.append(a[j]).append(" ");
            }
            start = idx >= 0 ? idx:idx*(-1) - 1;
        }

        System.out.println(cnt > 0 ? cnt+"\n"+sb:0);
    }
}