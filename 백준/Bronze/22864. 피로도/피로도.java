import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int w = 0;
        int fatigue = 0;
        
        for(int i=0; i<24; i++){
            if(fatigue+a <= m){
                w += b;
                fatigue += a;
            } else {
                fatigue = (fatigue >= c) ? fatigue-c:0;
            }
        }
        System.out.println(w);
    }
}