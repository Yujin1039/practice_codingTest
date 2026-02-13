import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 건물의 개수
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // 남은 시간
        int M = Integer.parseInt(st.nextToken()); // 돈
        
        int L = Integer.parseInt(br.readLine()); // 길의 개수

        List<List<int[]>> adj = new ArrayList<>(); // 길 저장 리스트
        for(int i=0; i<=N; i++){
            adj.add(new ArrayList<int[]>());
        }

        // 길 정보 저장
        for(int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            if(t <= T && m <= M){
                adj.get(s).add(new int[]{e,t,m});
                adj.get(e).add(new int[]{s,t,m});
            }            
        }

        // 지출 기록
        int[][] minCost = new int[N+1][T+1];
        for(int i=0; i<=N; i++){
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }
        // 지출 계산
        int min = -1;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2) -> o1[2]-o2[2]);
        queue.add(new int[]{1, 0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(cur[2] > minCost[cur[0]][cur[1]]) continue;
            
            if(cur[0] == N) {
                min = cur[2];
                break;
            }
            
            List<int[]> next = adj.get(cur[0]);
            for (int[] node : next) {
                int time = cur[1]+node[1];
                int money = cur[2]+node[2];
                if(time <= T && money <= M && money < minCost[node[0]][time]){     
                    minCost[node[0]][time] = money;
                    queue.add(new int[]{node[0], cur[1]+node[1], cur[2]+node[2]});
                }
            }
        }
        System.out.println(min);
    }
}