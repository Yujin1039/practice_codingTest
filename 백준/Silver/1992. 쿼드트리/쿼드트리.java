import java.util.*;
import java.io.*;

public class Main {    
    static int[][] video;
    static StringBuilder densedStr;

    static void quadTree(int x, int y, int n){
        boolean isQuad = true;
        int start = video[x][y];
        loop:
        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(video[i][j] != start){
                    isQuad = false;
                    break loop;
                }
            }
        }
        
        if(isQuad) {            
            densedStr.append(start);
        } else {
            densedStr.append("(");
            quadTree(x, y, n/2);                    
            quadTree(x, y+n/2, n/2);
            quadTree(x+n/2, y, n/2);
            quadTree(x+n/2, y+n/2, n/2); 
            densedStr.append(")");
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        video = new int[N][N];        
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                video[i][j] = str.charAt(j) - '0';
            }
        }

        densedStr = new StringBuilder();
        quadTree(0, 0, N);
        System.out.println(densedStr.toString());
    }
}