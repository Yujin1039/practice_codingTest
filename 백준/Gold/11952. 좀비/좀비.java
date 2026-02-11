import java.util.*;
import java.io.*;

public class Main {
    private static int[][] xy = new int[][]{{0,1,0,-1},{1,0,-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 도시
        int M = Integer.parseInt(st.nextToken()); // 길
        int K = Integer.parseInt(st.nextToken()); // 좀비 도시
        int S = Integer.parseInt(st.nextToken()); // 위험 범위

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken()); // 안전 숙박비
        int q = Integer.parseInt(st.nextToken()); // 위험 숙박비
        
        // 숙박비
        int[] fee = new int[N+1];
        Arrays.fill(fee, p);
        
        int[] zombie = new int[K]; // 좀비 도시
        boolean[] isZombie = new boolean[N+1]; // 좀비 도시 여부
        ArrayDeque<int[]> queue = new ArrayDeque<>(); // 위험 도시 판별용 큐
        boolean[] isVisited = new boolean[N+1]; // 위험 도시 방문 여부
        for(int i=0; i<K; i++){
            int num = Integer.parseInt(br.readLine());
            zombie[i] = num;
            fee[num] = q;
            isVisited[num] = true;
            isZombie[num] = true;
            queue.add(new int[]{0, num});
        }
        
        // 도시 연결 리스트
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<N+1; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            adj.get(s).add(e);
            adj.get(e).add(s);
        }

        // 위험 도시 숙박비 업데이트        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            List<Integer> next = adj.get(cur[1]);
            for (int node : next) {
                if(!isVisited[node] && cur[0] < S){
                    fee[node] = q;
                    isVisited[node] = true;
                    queue.add(new int[]{cur[0]+1, node});
                }
            }
        }
        
        // 최소비용 계산
        PriorityQueue<long[]> pq = new PriorityQueue<>((o1,o2) -> Long.compare(o1[0], o2[0]));
        pq.add(new long[]{0, 1});
        isVisited[1] = true;
        long ans = 0L; boolean flag = true;
        Arrays.fill(isVisited, false);
        while (!pq.isEmpty() && flag) {
            long[] cur = pq.poll();
            
            List<Integer> next = adj.get((int) cur[1]);
            for (int node : next) {
                if(node == N){
                    ans = cur[0];
                    flag = false;
                    break;                    
                } else if(!isZombie[node] && !isVisited[node]) {
                    pq.add(new long[]{cur[0]+fee[node], node});
                    isVisited[node] = true;
                }
            }
        }
        System.out.println(ans);
    }
}