import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] divideNum = new int[12];
        divideNum[1] = 1;
        divideNum[2] = 2;
        divideNum[3] = 4;
        for(int i=4;i<=11;i++){
            divideNum[i] = divideNum[i-1] + divideNum[i-2] + divideNum[i-3];                    
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            int N = Integer.parseInt(br.readLine());
            sb.append(divideNum[N]).append("\n");
        }        
        System.out.println(sb);
    }
}