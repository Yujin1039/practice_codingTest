import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if(n == 1){
            System.out.printf("%d\n%d",0,1);
            return;
        }else if(n == 2){
            System.out.printf("%d\n%d %d",1,2,1);
            return;
        }
        
        int[][] dv = new int[n+1][2];
        dv[1][1] = dv[2][1] = dv[3][1] = 1;
        dv[2][0] = dv[3][0] = 1;
        for(int i=4;i<=n;i++){
            dv[i][0] = dv[i-1][0] + 1;
            dv[i][1] = i-1;
            if(i % 3 == 0){
                dv[i][0] = Math.min(dv[i][0],dv[i/3][0]+1);
                if(dv[i][0] == dv[i/3][0]+1) dv[i][1] = i/3;
            }
            if(i % 2 == 0){
                dv[i][0] = Math.min(dv[i][0],dv[i/2][0]+1);
                if(dv[i][0] == dv[i/2][0]+1) dv[i][1] = i/2;
            }
        }     
                
        StringBuilder sb = new StringBuilder(dv[n][0]+"\n"+n+" ");
        for(int i=dv[n][1];i>1;i = dv[i][1]){
            sb.append(i).append(" ");
        }
        sb.append(1);
        System.out.println(sb);
    }
}