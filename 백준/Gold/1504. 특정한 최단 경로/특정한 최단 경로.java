import java.util.*;
import java.io.*;

public class Main { 
    static long INF = 200_000_001L;
    static int N;
    static List<ArrayList<int[]>> adj;
    
    static long dijkstra(int start, int end){
        long[] dis = new long[N+1];
        Arrays.fill(dis,INF);
        
        PriorityQueue<long[]> queue = new PriorityQueue<>((o1,o2)->Long.compare(o1[1],o2[1]));
        queue.add(new long[]{start,0});

        while(!queue.isEmpty()){
            long[] cur = queue.poll();
            int s = (int) cur[0];
            long cost = cur[1];

            for(int[] arr:adj.get(s)){
                if(dis[arr[0]] > cost+arr[1]){
                    dis[arr[0]] = cost+arr[1];
                    queue.add(new long[]{arr[0],dis[arr[0]]});
                }
            }
        }
        return dis[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for(int i=0; i<=N; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<E; i++){
            st =  new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.get(a).add(new int[]{b,c});
            adj.get(b).add(new int[]{a,c});
        }

        st =  new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        long m1 = v1 == 1 ? 0:dijkstra(1,v1);
        long m2 = dijkstra(v1,v2);
        long m3 = v2 == N ? 0:dijkstra(v2,N);
        
        long m4 = dijkstra(1,v2);
        long m5 = dijkstra(v2,v1);
        long m6 = dijkstra(v1,N);

        if(m1 == INF || m2 == INF || m3 == INF || m4 == INF || m5 == INF || m6 == INF){
            System.out.println(-1);
        } else {
            System.out.println(Math.min(m1+m2+m3, m4+m5+m6));
        }
    }
}