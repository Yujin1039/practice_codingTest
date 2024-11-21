import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] A = new int[a];
        int[] B = new int[b];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<a;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<b;i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int[] merge = new int[a+b];
        int pa = 0; int pb = 0;
        for(int i=0;i<(a+b);i++){
            int sa = pa < a ? A[pa]:1000000001;
            int sb = pb < b ? B[pb]:1000000001;
            if(sa < sb) pa++;
            else pb++;
            merge[i] = Math.min(sa,sb);               
        } 
        System.out.println(Arrays.toString(merge).replace("[","").replace("]","").replace(",",""));
    }
}