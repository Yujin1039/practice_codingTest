import java.util.*;
import java.io.*;

public class Main {
    static int[][] paperMatrix;
    static int[] result = new int[3];

    static void paper(int x,int y, int n){
        int p = paperMatrix[x][y];
        boolean isUniform = true;
        
        for(int i=x;i<x+n;i++){
            for(int j=y;j<y+n;j++){
                if(paperMatrix[i][j] != p){
                    isUniform = false;
                    break;
                }
            }
        }
        if(isUniform || n == 1){
            result[p+1]++;
            return;
        } else{
            for(int i=x;i<x+n;i += n/3){
                for(int j=y;j<y+n;j += n/3){
                    paper(i,j,n/3);
                }
            }
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
        System.out.println(result[0]+"\n"+result[1]+"\n"+result[2]);
    }
}