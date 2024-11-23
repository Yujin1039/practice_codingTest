import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        int i = 0;

        while(st != null){
            while(st.hasMoreTokens()){
                StringBuilder sb = new StringBuilder(st.nextToken()).reverse();
                arr[i++] = Long.parseLong(sb.toString());
            }
            String str = br.readLine();
            if(str == null) break;
            else st = new StringTokenizer(str);
        }
        
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr).replace("[","").replace("]","").replace(", ","\n"));
    }
}