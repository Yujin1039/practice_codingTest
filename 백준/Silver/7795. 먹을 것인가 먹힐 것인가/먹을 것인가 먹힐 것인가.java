import java.io.*;
import java.util.*;

public class Main { 
    static int getPair(long[] a,long[] b){
        int pair = 0;
        
        Arrays.sort(b);
        for(int i=0;i<a.length;i++){
            for(int j=0;j<b.length;j++){
                if(a[i] <= b[j]) break;
                pair++;
            }
        }
        return pair;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long[] arrA = new long[a];
            long[] arrB = new long[b];

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<a;j++){
                arrA[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<b;j++){
                arrB[j] = Integer.parseInt(st.nextToken());
            }
            sb.append(getPair(arrA,arrB)).append("\n");
        }
        System.out.println(sb);
    }
}