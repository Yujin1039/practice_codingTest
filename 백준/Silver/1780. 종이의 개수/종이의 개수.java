import java.util.*;
import java.io.*;

public class Main {
    static int[][] paperMatrix;
    static int minus = 0;
    static int zero = 0;
    static int plus = 0;

    static void paper(int x,int y, int n){
        int p = paperMatrix[x][y];
        if(n == 1){
            if(p == -1) minus++;
            else if(p == 0) zero++;
            else plus++;
            return;
        }

        boolean isUniform = true;
        for(int i=x;i<x+n;i++){
            for(int j=y;j<y+n;j++){
                if(paperMatrix[i][j] != p){
                    isUniform = false;
                    break;
                }
            }
        }
        if(isUniform){
            if(p == -1) minus++;
            else if(p == 0) zero++;
            else plus++;
        } else{
            paper(x,y,n/3);
            paper(x,y+n/3,n/3);
            paper(x,y+2*n/3,n/3);
            paper(x+n/3,y,n/3);
            paper(x+n/3,y+n/3,n/3);
            paper(x+n/3,y+2*n/3,n/3);
            paper(x+2*n/3,y,n/3);
            paper(x+2*n/3,y+n/3,n/3);
            paper(x+2*n/3,y+2*n/3,n/3);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paperMatrix = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                paperMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        paper(0,0,n);
        System.out.println(minus+"\n"+zero+"\n"+plus);
    }
}