import java.util.*;
import java.io.*;

public class Main {    
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 도시 개수
        int M = Integer.parseInt(br.readLine()); // 버스 개수
        
        // 최단거리 배열
        int[] dis = new int[N+1];
        Arrays.fill(dis,INF);

        // 인접 노드 확인용 리스트
        List<ArrayList<int[]>> adj = new ArrayList<>();
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
        
        // 다익스트라 구현을 위한 우선순위 큐
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((o1,o2) -> o1[0]-o2[0]);
        st =  new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        queue.add(new int[]{0,s});

        // 최단거리 찾기
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int start = cur[1];
            
            if(cur[0] > dis[start]) continue;

            dis[start] = cur[0];
            
            for(int[] edge : adj.get(start)){
                int end = edge[1];
                if(dis[end] > dis[start]+edge[0]){
                    dis[end] = dis[start]+edge[0];
                    queue.add(new int[]{dis[end],end});
                }                
            }       
        }
        System.out.println(dis[e]);
    }
}