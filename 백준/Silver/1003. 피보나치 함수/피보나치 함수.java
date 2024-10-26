import java.util.*;
import java.io.*;

public class Main {
    static int[][] fibonacci = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fibonacci[0] = new int[]{1,0};
        fibonacci[1] = new int[]{0,1};

        for(int i=2;i<=40;i++){
            fibonacci[i][0] = fibonacci[i-1][0] + fibonacci[i-2][0];
            fibonacci[i][1] = fibonacci[i-1][1] + fibonacci[i-2][1];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            int m = Integer.parseInt(br.readLine());
            sb.append(fibonacci[m][0]+" "+fibonacci[m][1]).append("\n");
        }
        System.out.println(sb.toString());
    }
}