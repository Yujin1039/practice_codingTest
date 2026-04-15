import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            String cmd = br.readLine();
            int sx = 0; int sy = 0;
            int ex = 0; int ey = 0;

            int[] cur = new int[]{0,0,0};
            
            for(int j=0; j<cmd.length(); j++){
                char c = cmd.charAt(j);

                if(c == 'F'){
                    if(cur[2] == 0) cur[1]++;
                    else if(cur[2] == 1) cur[0]--;
                    else if(cur[2] == 2) cur[1]--;
                    else cur[0]++;
                } else if(c == 'B'){
                    if(cur[2] == 0) cur[1]--;
                    else if(cur[2] == 1) cur[0]++;
                    else if(cur[2] == 2) cur[1]++;
                    else cur[0]--;
                } else if(c == 'L'){
                    cur[2] = (cur[2]+1) % 4;
                } else {
                    cur[2] = ((cur[2]-1) % 4 + 4) % 4;
                }

                sx = Math.min(cur[0], sx);
                sy = Math.min(cur[1], sy);
                ex = Math.max(cur[0], ex);
                ey = Math.max(cur[1], ey);
            }

            sb.append((ex-sx)*(ey-sy)+"\n");
        }
        System.out.println(sb.toString());
    }
}