import java.io.*;
import java.util.*;

public class Main { 
    static int findInsertIdx(int[] a,int tmp){
        int start = 0;
        int end = a.length;
        
        while(start < end){
            int mid = (start+end)/2;
            if(tmp >= a[mid]) start = mid+1;
            else end = mid;
        }
        return start;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int a; int b; int cnt;

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            cnt = 0;
            int[] arrA = new int[a];

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<a;j++){
                arrA[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arrA);
            
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<b;j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp > arrA[a-1]) continue;
                cnt += a-findInsertIdx(arrA,tmp);                
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}