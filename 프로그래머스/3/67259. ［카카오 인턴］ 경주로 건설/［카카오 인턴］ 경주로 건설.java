import java.util.*;

class Solution {
    static int[] direction = new int[]{0,1,2,3};
    static int[][] xy = new int[][]{{0,1,0,-1},{1,0,-1,0}}; 
    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int n = board.length;
        int[][][] isVisited = new int[n][n][4];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==0 && j==0) continue;
                Arrays.fill(isVisited[i][j], Integer.MAX_VALUE);
            }
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o1[0]-o2[0]);
        for(int i=0; i<4; i++){
            int x = xy[0][i];
            int y = xy[1][i]; 
            
            if(x < 0 || x >= n || y < 0 || y >= n || board[x][y] == 1) continue;
            pq.add(new int[]{100,x,y,direction[i]});
        }
        while(!pq.isEmpty()){
            int[] cur = pq.poll(); 
            
            if(cur[0] > isVisited[cur[1]][cur[2]][cur[3]]) continue;
            
            for(int i=0; i<4; i++){
                int x = cur[1] + xy[0][i];
                int y = cur[2] + xy[1][i];
                
                if(x < 0 || x >= n || y < 0 || y >= n || board[x][y] == 1) continue;
                
                int p = cur[0];
                if(cur[3] == -1 || cur[3] == direction[i]) p += 100;
                else p += 600;
                
                isVisited[x][y][direction[i]] = Math.min(isVisited[x][y][direction[i]], p);
                pq.add(new int[]{p,x,y,direction[i]});
            }

        }
        
        for(int i=0; i<4; i++){
            answer = Math.min(answer, isVisited[n-1][n-1][i]);
        }
        return answer;
    }
}