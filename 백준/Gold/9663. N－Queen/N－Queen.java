import java.util.*;
import java.io.*;

class Main {
    static int n;
    static int queens;
    static boolean[] visCol;
    static boolean[] visLeft; // / 방향 대각선
    static boolean[] visRight;// \ 방향 대각선

    public static void nQueen(int k) {
        if(k == n){
            queens++;
            return;
        }
        for(int i=0;i<n;i++){
            if(!visCol[i] && !visLeft[k+i] && !visRight[k-i+n-1]){
                visCol[i] = true;
                visLeft[k+i] = true;
                visRight[k-i+n-1] = true;
                nQueen(k+1);
                visCol[i] = false;
                visLeft[k+i] = false;
                visRight[k-i+n-1] = false;
            }
        }
        
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visCol = new boolean[n];
        visLeft = new boolean[2*n-1];
        visRight = new boolean[2*n-1];

        nQueen(0);
        System.out.println(queens);
    }
}