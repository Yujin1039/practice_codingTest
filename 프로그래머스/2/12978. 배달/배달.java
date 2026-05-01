import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        List<List<int[]>> list = new ArrayList<>();
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i=0; i<road.length; i++){
            int s = road[i][0];
            int e = road[i][1];
            int t = road[i][2];
            list.get(s).add(new int[]{e,t});
            list.get(e).add(new int[]{s,t});
        }
        
        int[] dis = new int[N+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        queue.add(new int[]{1,0});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int s = cur[0];
            int t = cur[1];
            
            if(t > K) continue;
            
            List<int[]> adj = list.get(s);
            for(int[] info:adj){
                if(dis[info[0]] > t+info[1]){
                    dis[info[0]] = t+info[1];
                    queue.add(new int[]{info[0],dis[info[0]]});
                }
            }
        }
        
        for(int i=1; i<=N; i++){
            if(dis[i] <= K) answer++;
        }
        return answer;
    }
}