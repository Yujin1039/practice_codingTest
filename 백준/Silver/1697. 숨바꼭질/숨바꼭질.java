import java.util.*;
import java.io.*;
    
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        StringTokenizer st = new StringTokenizer(br.readLine());
        int subin = Integer.parseInt(st.nextToken());
        int bro = Integer.parseInt(st.nextToken());            

        int[] cor = new int[Math.max(subin,bro)+2];
        Arrays.fill(cor,-1);
        cor[subin] = 0;
        int[] dx = new int[]{-1,1,2};
        Queue<Integer> queue = new LinkedList<>();
        queue.add(subin);

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int i=0;i<3;i++){
                int cx = 0;
                if(i == 2) cx = cur * dx[2];
                else cx = cur + dx[i];

                if(cx < 0 || cx >= cor.length || cor[cx] != -1 ) continue;
                queue.add(cx);
                cor[cx] = cor[cur] + 1;
            }
        }
        System.out.println(cor[bro]);
    }
}