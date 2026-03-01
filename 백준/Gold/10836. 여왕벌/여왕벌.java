import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] bee = new int[M][M];
        Arrays.fill(bee[0],1);
        for(int i=0; i<M; i++){
            bee[i][0] = 1;
        }
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int zero = Integer.parseInt(st.nextToken());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int[] add = new int[zero+one+two];            
            Arrays.fill(add,0,zero,0);
            Arrays.fill(add,zero,zero+one,1);
            Arrays.fill(add,zero+one,zero+one+two,2);

            int idx = 0;
            for(int j=M-1; j>=0; j--){                
                bee[j][0] += add[idx++];
            }
            for(int j=1; j<M; j++){
                bee[0][j] += add[idx++];
            }
        }

        for(int i=1; i<M; i++){
            for(int j=1; j<M; j++){
                bee[i][j] = Math.max(Math.max(bee[i][j-1],bee[i-1][j]),bee[i-1][j-1]);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            for(int j=0; j<M; j++){
                sb.append(bee[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}