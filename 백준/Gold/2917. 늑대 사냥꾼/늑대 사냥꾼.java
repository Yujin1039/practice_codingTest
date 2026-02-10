import java.util.*;
import java.io.*;

public class Main {
    private static int[][] xy = new int[][]{{0,1,0,-1},{1,0,-1,0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        char[][] forest = new char[n][m];
        int wx = 0; int wy = 0;
        ArrayDeque<int[]> hunters = new ArrayDeque<>();
        int[][] minMap = new int[n][m];
        for (int[] row: minMap) {
            Arrays.fill(row, -1);
        }
        
        for (int i=0; i<n; i++) {
            String line = br.readLine();            
            for(int j=0; j<m; j++){
                forest[i][j] = line.charAt(j);
                if(forest[i][j] == 'V') {
                    wx = i;
                    wy = j;
                } else if(forest[i][j] == '+') {
                    hunters.add(new int[]{i,j});
                    minMap[i][j] = 0;
                }
            }
        }

        // 각 지점별로 나무에서 떨어진 최소거리 저장
        while (!hunters.isEmpty()) {
            int[] cur = hunters.poll();
            for(int i=0; i<4; i++){
                int x = cur[0] + xy[0][i];
                int y = cur[1] + xy[1][i];

                if(x < 0 || x >= n || y < 0 || y >=m || minMap[x][y] != -1) continue;

                minMap[x][y] = minMap[cur[0]][cur[1]]+1;
                hunters.add(new int[]{x,y});
            }
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0]-o1[0]);
        queue.add(new int[]{minMap[wx][wy], wx, wy});
        
        boolean[][] isVisited = new boolean[n][m];
        isVisited[wx][wy] = true;
        
        int ans = 0;
        boolean flag = true;

        // 나무와 현우간 거리가 최대인 경로 찾기
        while (!queue.isEmpty() && flag) {
            int[] cur = queue.poll();
            for(int i=0; i<4; i++){
                int x = cur[1] + xy[0][i];
                int y = cur[2] + xy[1][i];

                if(x < 0 || x >= n || y < 0 || y >=m || isVisited[x][y]) continue;
   
                int dis = Math.min(cur[0], minMap[x][y]);
                if(forest[x][y] == 'J') {
                    ans = dis;
                    flag = false;
                    break;
                } 
                queue.add(new int[]{dis, x, y});
                isVisited[x][y] = true;
            }
        }
        System.out.println(ans);
    }
}