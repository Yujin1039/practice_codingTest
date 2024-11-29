import java.io.*;
import java.util.*;

public class Main { 
    static int[][] videos;
    static int n;
    static StringBuilder sb = new StringBuilder();
    
    static void quadTree(int[] xy,int sub){
        int start = videos[xy[0]][xy[1]];
        if(sub == 1) {
            sb.append(start); 
            return;
        }
        boolean isSame = true;

        fin:
        for(int i=xy[0];i<xy[0]+sub;i++){
            for(int j=xy[1];j<xy[1]+sub;j++){
                if(videos[i][j] != start){
                    sb.append("(");
                    isSame = false;
                    int num = sub/2;          
                    quadTree(new int[]{xy[0],xy[1]},num);
                    quadTree(new int[]{xy[0],xy[1]+num},num);
                    quadTree(new int[]{xy[0]+num,xy[1]},num);
                    quadTree(new int[]{xy[0]+num,xy[1]+num},num);
                    sb.append(")");
                    break fin;
                }
            }
        }
        if(isSame) sb.append(start);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        videos = new int[n][n];

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<n;j++){
                videos[i][j] = str.charAt(j)-48;
            }
        }

        quadTree(new int[]{0,0},n);
        System.out.println(sb);
    }
}