import java.util.*;
import java.io.*;

public class Main {    
    static int INF = Integer.MAX_VALUE;
    static int N;
    static List<ArrayList<int[]>> adj;
    static PriorityQueue<int[]> queue;
    
    static int dijkstra(int s, int X){
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
        return dis[X];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 학생 수
        int M = Integer.parseInt(st.nextToken()); // 도로 수
        int X = Integer.parseInt(st.nextToken()); // 파티 장소

        // 인접 노드 확인용 리스트
        adj = new ArrayList<>();
        for(int i=0; i<=N; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<M; i++){
            st =  new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adj.get(start).add(new int[]{cost,end});
        }

        // 각 학생별 최단거리 배열
        int[] min_dis = new int[N+1];

        // 파티 장소 이동
        for(int i=1; i<=N; i++){
            min_dis[i] = dijkstra(i,X);
        }

        // 마을 복귀
        int[] dis_re = new int[N+1];
        Arrays.fill(dis_re,INF);

        queue = new PriorityQueue<int[]>((o1,o2) -> o1[0]-o2[0]);
        queue.add(new int[]{0,X});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int start = cur[1];
            
            if(cur[0] > dis_re[start]) continue;

            dis_re[start] = cur[0];
            
            for(int i=0; i<adj.get(start).size(); i++){
                int end = adj.get(start).get(i)[1];
                if(dis_re[end] > dis_re[start]+adj.get(start).get(i)[0]){
                    dis_re[end] = dis_re[start]+adj.get(start).get(i)[0];
                    queue.add(new int[]{dis_re[end],end});
                }                
            }       
        }
        
        for(int i=1; i<=N; i++){
            min_dis[i] += dis_re[i];
        }

        int max = 0;
        for(int min:min_dis){
            if(min > max) max = min;
        }
        
        System.out.println(max);
    }
}