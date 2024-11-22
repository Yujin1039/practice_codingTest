import java.io.*;
import java.util.*;

public class Main {
    static boolean[] cntNum = new boolean[2000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0;i<n;i++){
            cntNum[Integer.parseInt(br.readLine())+1000000] = true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=2000000;i>=0;i--){
            if(cntNum[i]){
                sb.append(i-1000000).append("\n");
            } 
        }
        System.out.println(sb);
    }
}