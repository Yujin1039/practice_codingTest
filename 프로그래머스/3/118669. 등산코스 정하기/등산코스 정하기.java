import java.util.*;

class Solution {
    static List<List<int[]>> adj;
    static char[] classify;
    static int[] minDis;
    
    static void findIntensity(PriorityQueue<int[]> pq){               
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int dis = cur[0];
            int prev = cur[1];
            
            if(dis > minDis[prev] || classify[prev] == 's') continue;
            
            List<int[]> list = adj.get(prev);
            for(int[] node: list){
                int next = node[0];
                int move = node[1];
                
                if(minDis[next] > Math.max(dis, move)){ // 헷갈린 부분
                    minDis[next] = Math.max(dis, move);
                    pq.add(new int[]{minDis[next], next}); 
                }
            }
        }
        
        
        
    }
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {        
        adj = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<paths.length; i++){
            int s = paths[i][0];
            int e = paths[i][1];
            int m = paths[i][2];
            
            adj.get(s).add(new int[]{e,m});
            adj.get(e).add(new int[]{s,m});
        }
        
        classify = new char[n+1];
        for(int i:gates){
            classify[i] = 'g';
        }
        for(int i:summits){
            classify[i] = 's';
        }
        
        minDis = new int[n+1];
        Arrays.fill(minDis, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[0]-o2[0]);
        for(int i:gates){
            pq.add(new int[]{0,i});                               
        }
        findIntensity(pq);
        
        int intensity = Integer.MAX_VALUE;
        int summit = 0;
        for(int i=1; i<=n; i++){
            if(classify[i] == 's' && minDis[i] < intensity){
                intensity = minDis[i];
                summit = i;
            }
        }
        return new int[]{summit, intensity};
    }
}