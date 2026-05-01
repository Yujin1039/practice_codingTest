import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<edge.length; i++){
            int node1 = edge[i][0];
            int node2 = edge[i][1];
            
            adj.get(node1).add(node2);
            adj.get(node2).add(node1);
        }
        
        int[] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[0]-o2[0]);
        pq.add(new int[]{0,1});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int move = cur[0];
            int node = cur[1];

            for(int n2:adj.get(node)){
                if(dis[n2] > move+1){
                    dis[n2] = move+1;
                    pq.add(new int[]{move+1,n2});
                }
            }            
        }

        Arrays.sort(dis);        
        int max = dis[n-1];
        for(int i=n; i>=1; i--){
            if(dis[i] == max) answer++;
        }
        
        return answer;
    }
}