import java.util.*;
import java.io.*;

class Main {
    static int[][] papers;
    static int white;
    static int blue;

    static void dividePapers(int x, int y, int n){
        int start = papers[x][y];
        
        if(isSquare(x,y,n,start)){
            if(start == 0) white++;
            else blue++;
            return;
        }
        dividePapers(x,y,n/2);
        dividePapers(x+n/2,y,n/2);
        dividePapers(x,y+n/2,n/2);
        dividePapers(x+n/2,y+n/2,n/2);
    }

    static boolean isSquare(int x, int y, int n,int start){        
        for(int i=x;i<x+n;i++){
            for(int j=y;j<y+n;j++){
                if(papers[i][j] != start) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        papers = new int[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dividePapers(0,0,n);
        System.out.println(white+"\n"+blue);
    }
}