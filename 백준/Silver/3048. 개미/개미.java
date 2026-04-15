import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N1 = Integer.parseInt(st.nextToken());
        int N2 = Integer.parseInt(st.nextToken());

        String g1 = new StringBuilder(br.readLine()).reverse().toString();
        String g2 = br.readLine();

        int[] move = new int[N1+N2];
        for(int i=0; i<g1.length(); i++){
            move[i] = 1;
        }

        int t = Integer.parseInt(br.readLine());
        for(int i=1; i<=t; i++){
            for(int j=N1+N2-1; j>0; j--){
                if(move[j-1] == 1 && move[j] == 0){
                    move[j] = 1;
                    move[j-1] = 0;
                    j--;
                }
            }                      
        }

        StringBuilder sb = new StringBuilder();
        int idx1 = 0; int idx2 = 0;
        for(int i=0; i<move.length; i++){
            if(move[i] == 0) sb.append(g2.charAt(idx2++));
            else sb.append(g1.charAt(idx1++));
        }
        
        System.out.println(sb.toString());
    }
}