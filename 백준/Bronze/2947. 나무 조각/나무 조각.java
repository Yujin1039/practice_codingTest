import java.io.*;
import java.util.*;

public class Main {  
    static int[] changeLoc(int[] piece){
        
        return piece;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] piece = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<5; i++){
            piece[i] = Integer.parseInt(st.nextToken());
        }
        int[] ans = piece.clone();
        Arrays.sort(ans);
        
        StringBuilder sb = new StringBuilder();
        while(!Arrays.equals(piece,ans)){
            for(int i=0; i<4; i++){
                if(piece[i] > piece[i+1]){
                    int tmp = piece[i];
                    piece[i] = piece[i+1];
                    piece[i+1] = tmp;
                    
                    for(int p : piece) {
                        sb.append(p+" ");
                    }
                    sb.append("\n");
                }
            }            
        }

        System.out.println(sb.toString());
    }
}