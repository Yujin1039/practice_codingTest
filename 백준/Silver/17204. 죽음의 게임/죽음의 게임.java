import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());                      
        
        int[] next = new int[N];
        for(int i=0; i<N; i++){
            next[i] = Integer.parseInt(br.readLine());
        }
        
        int[] min = new int[N];
        Arrays.fill(min, -1);
        min[0] = 1;
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0,0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int num = next[cur[0]];

            if(min[num] == -1){
                queue.add(new int[]{num,cur[1]+1});
                min[num] = cur[1]+1;
            }
        }
        System.out.println(min[K]);
    }
}