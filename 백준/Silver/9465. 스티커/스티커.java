import java.util.*;
import java.io.*;

public class Main { 
    static int maxScore(int[][] stickers,int n){
        if(n > 1) {
            stickers[0][1] += stickers[1][0]; 
            stickers[1][1] += stickers[0][0];
        }
        for(int i=2;i<n;i++){      // 세로
            for(int j=0;j<2;j++){  // 가로
                stickers[j][i] += Math.max(stickers[1-j][i-2],stickers[1-j][i-1]);
            }
        }
        return Math.max(stickers[0][n-1],stickers[1][n-1]);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int n = Integer.parseInt(br.readLine()); 
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            int m = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][m];
            for(int j=0;j<2;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0;k<m;k++){
                    int sticker = Integer.parseInt(st.nextToken());
                    stickers[j][k] = sticker;
                }
            }
            sb.append(maxScore(stickers, m)).append("\n");
        }
        System.out.println(sb);
        
    }
}