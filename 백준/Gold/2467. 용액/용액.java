import java.util.*;
import java.io.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int n = Integer.parseInt(br.readLine());
        int[] attr = new int[n]; 
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0;i<n;i++){
            attr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(attr);

        int sum = Integer.MAX_VALUE;
        int first = 0; int second = 0;
        int cur = 0; int last = n-1;
        while(cur < last){
            int sub = attr[cur] + attr[last];
            if(Math.abs(sub) < Math.abs(sum)){
                sum = sub;
                first = attr[cur]; second = attr[last];
            }

            if(sub == 0){
                System.out.println(first+" "+second);
                return;
            }else if(sub < 0) cur++;
            else last--;
        }
        System.out.println(first+" "+second);
    }
}