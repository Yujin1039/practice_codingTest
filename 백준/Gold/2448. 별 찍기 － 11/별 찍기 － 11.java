import java.util.*;
import java.io.*;

public class Main { 
    static int n;
    static char[][] starBox;

    static int exp(int base,int result){
        int r = 0;
        while(result > 1){
            result /= base;
            r++;
        }
        return r;
    }
    static void drawStar(int x,int y,int cur){
        if(cur == 0){
            starBox[x][y] = '*';
            starBox[x+1][y-1] = '*';
            starBox[x+1][y+1] = '*';
            for(int i=y-2;i<=y+2;i++){
                starBox[x+2][i] = '*';
            }
            return;
        }
        int differ = 3 * (int) Math.pow(2,cur-1);
        drawStar(x+differ,y-differ,cur-1);
        drawStar(x,y,cur-1);
        drawStar(x+differ,y+differ,cur-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        n = Integer.parseInt(br.readLine());
        starBox = new char[n][n*2-1];
        
        drawStar(0,n-1,exp(2,n/3));
        
        StringBuilder sb = new StringBuilder();
        for(char[] ch:starBox){
            for(char c:ch){
                if(c == '*') sb.append("*");
                else sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}