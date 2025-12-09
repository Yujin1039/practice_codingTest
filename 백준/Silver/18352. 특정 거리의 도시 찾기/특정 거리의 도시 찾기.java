import java.util.*;
import java.io.*;

public class Main {    
    static int INF = 300_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] dis = new int[N+1]; // 최단거리 배열
        Arrays.fill(dis,INF);

        List<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=N; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st =  new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj.get(start).add(end);
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        dis[X] = 0;
        queue.add(new int[]{0,X});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int start = cur[1];

            if(dis[start] > K) continue;

            for(int u: adj.get(start)){
                if(dis[u] > cur[0]+1){
                    dis[u] = cur[0]+1;
                    queue.add(new int[]{cur[0]+1,u});
                }
            }  
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<dis.length; i++){
            if(dis[i] == K) sb.append(i+"\n");
        }
        
        System.out.println(sb.toString().isEmpty() ? "-1":sb.toString());
    }
}