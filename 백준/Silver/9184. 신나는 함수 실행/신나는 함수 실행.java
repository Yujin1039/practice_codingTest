import java.util.*;
import java.io.*;

public class Main {    
    static int[][][] wResult;
    
    static int w(int a, int b, int c){
        
        if(a <= 0 || b <= 0 || c <= 0){
            return 1;
        } if(wResult[a][b][c] != 0) {
            return wResult[a][b][c];        
        } else if(a > 20 || b > 20 || c > 20){
            return w(20,20,20);
        } else if(a < b && b < c){
            return wResult[a][b][c] = w(a,b,c-1) + w(a,b-1,c-1) - w(a,b-1,c);
        } else {
            return wResult[a][b][c] = w(a-1,b,c) + w(a-1,b-1,c) + w(a-1,b,c-1) - w(a-1,b-1,c-1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cmd = br.readLine();
        wResult = new int[51][51][51];
        StringBuilder sb = new StringBuilder();

        while (!cmd.equals("-1 -1 -1")) {            
            StringTokenizer abc = new StringTokenizer(cmd);
            int a = Integer.parseInt(abc.nextToken());
            int b = Integer.parseInt(abc.nextToken());
            int c = Integer.parseInt(abc.nextToken());            
            int result = w(a,b,c);
            
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(result).append("\n");
            cmd = br.readLine();
        }
        System.out.println(sb.toString());
    }
}