import java.util.*;
import java.io.*;

public class Main {    
    static int INF = Integer.MAX_VALUE;
    static int N;
    static PriorityQueue<int[]> queue;
    
    static int[] dijkstra(int s, List<ArrayList<int[]>> adj){
        // 최단거리 배열
        int[] dis = new int[N+1];
        Arrays.fill(dis,INF);

        // 다익스트라 구현을 위한 우선순위 큐
        queue = new PriorityQueue<int[]>((o1,o2) -> o1[0]-o2[0]);
        queue.add(new int[]{0,s});

        // 최단거리 찾기
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int start = cur[1];
            
            if(cur[0] > dis[start]) continue;

            dis[start] = cur[0];
            
            for(int i=0; i<adj.get(start).size(); i++){
                int end = adj.get(start).get(i)[1];
                if(dis[end] > dis[start]+adj.get(start).get(i)[0]){
                    dis[end] = dis[start]+adj.get(start).get(i)[0];
                    queue.add(new int[]{dis[end],end});
                }                
            }       
        }
        return dis;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 도로 수
        int X = Integer.parseInt(st.nextToken()); // 파티 장소

        List<ArrayList<int[]>> adj = new ArrayList<>(); // 학생->파티 이동 리스트 (마을 복귀시 확인)
        List<ArrayList<int[]>> adj_rev = new ArrayList<>(); // 파티->학생 이동 리스트 (파티로 출발시 확인)
        for(int i=0; i<=N; i++){
            adj.add(new ArrayList<>());
            adj_rev.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st =  new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj.get(start).add(new int[]{cost,end});
            adj_rev.get(end).add(new int[]{cost,start});
        }

        
        int[] dis_de = dijkstra(X, adj_rev); // 파티 도착 최단 거리
        int[] dis_re = dijkstra(X, adj); // 마을 복귀 최단 거리

        int max = 0;
        for(int i=1; i<=N; i++){
            max = Math.max(max, dis_de[i]+dis_re[i]);
        }
        
        System.out.println(max);
    }
}