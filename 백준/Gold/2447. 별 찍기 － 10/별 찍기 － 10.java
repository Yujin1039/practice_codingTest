import java.io.*;
import java.util.*;

public class Main { 
    static int n;
    static boolean[][] star;
    static void drawStar(int len,int x, int y,boolean draw){
        if(len == 1){
            if(draw){
                star[x][y] = true;
            } 
            return;
        }
        int sub = len/3;
        int cnt = 0;
        for(int i=x;i<x+len;i+=sub){
            for(int j=y;j<y+len;j+=sub){
                cnt++;
                if(cnt == 5) continue;
                drawStar(sub,i,j,true);
            }
        }        
    }
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        star = new boolean[n][n];

        drawStar(n,0,0,true);
        
        StringBuilder sb = new StringBuilder();
         for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sb.append(star[i][j] ? "*":" "); 
            }
             sb.append("\n");
        } 
        System.out.println(sb);
	}
}