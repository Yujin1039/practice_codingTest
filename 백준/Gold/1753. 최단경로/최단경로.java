import java.util.*;
import java.io.*;

public class Main {    
    static long INF = 6000000001L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st =  new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(br.readLine());

        // 최단거리 배열
        long[] dis = new long[V+1];
        Arrays.fill(dis,INF);

        // 인접 노드 확인용 리스트
        List<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<=V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<E; i++){
            st =  new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj.get(start).add(new int[]{cost,end});
        }
        
        // 다익스트라 구현을 위한 우선순위 큐
        PriorityQueue<long[]> queue = new PriorityQueue<long[]>((o1,o2) -> Long.compare(o1[0],o2[0]));
        queue.add(new long[]{0,s});

        // 최단거리 찾기
        while (!queue.isEmpty()) {
            long[] cur = queue.poll();
            int start = (int) cur[1];
            
            if(cur[0] > dis[start]) continue;

            dis[start] = cur[0];
            
            for(int i=0; i<adj.get(start).size(); i++){
                int end = adj.get(start).get(i)[1];
                if(dis[end] > dis[start]+adj.get(start).get(i)[0]){
                    dis[end] = dis[start]+adj.get(start).get(i)[0];
                    queue.add(new long[]{dis[end],end});
                }                
            }       
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<V+1; i++){
            sb.append(dis[i] == INF ? "INF":dis[i]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}