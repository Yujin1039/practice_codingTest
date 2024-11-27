import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] stairs = new long[n+1][10];
        stairs[1] = new long[]{0,1,1,1,1,1,1,1,1,1};

        int[][] rules = new int[][]{{0,1,0},{1,0,2},{2,1,3},{3,2,4},
                                  {4,3,5},{5,4,6},{6,5,7},
                                  {7,6,8},{8,7,9},{9,8,0}};
        for(int i=2;i<=n;i++){
            for(int j=0;j<10;j++){
                stairs[i][rules[j][1]] += stairs[i-1][rules[j][0]] % 1000000000;
                if(j != 0 && j != 9) stairs[i][rules[j][2]] += stairs[i-1][rules[j][0]] % 1000000000;
            }
        }

        long answer = 0;
        for(int i=0;i<10;i++){
            answer += stairs[n][i];
        }
        System.out.println(answer % 1000000000);
    }
}