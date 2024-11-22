import java.io.*;
import java.util.*;

public class Main {
    static int[] cntNum = new int[2000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0;i<n;i++){
            cntNum[Integer.parseInt(br.readLine())+1000000]++;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<2000001;i++){
            if(cntNum[i] != 0){
                for(int j=0;j<cntNum[i];j++) sb.append(i-1000000).append("\n");
            } 
        }
        System.out.println(sb);
    }
}