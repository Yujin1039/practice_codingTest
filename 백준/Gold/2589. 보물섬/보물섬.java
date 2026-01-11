import java.util.*;
import java.io.*;

public class Main {
    static int w,h;
    static char[][] map;
    static boolean[][] isVisited;
    static int[][] dxy = new int[][]{{0,1,0,-1},{1,0,-1,0}};
    static int route = 0;

    public static void bfs(int[] point){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(point);
        isVisited[point[0]][point[1]] = true;

        int rot_num = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for(int i=0; i<4; i++){
                int x = cur[0]+dxy[0][i];
                int y = cur[1]+dxy[1][i];

                if(x < 0 || x > w-1 || y < 0 || y > h-1 || map[x][y] == 'W' || isVisited[x][y]) continue;

                isVisited[x][y] = true;
                rot_num = Math.max(cur[2]+1, rot_num);
                queue.add(new int[]{x,y,cur[2]+1});
            }
        }
        route = Math.max(route, rot_num);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        map = new char[w][h];
        isVisited = new boolean[w][h];

        for (int i=0; i<w; i++) {
            String line = br.readLine();
            for(int j=0; j<h; j++){
                map[i][j] = line.charAt(j);
            }
        }

        for (int i=0; i<w; i++) {
            for(int j=0; j<h; j++){
                if(map[i][j] == 'L'){
                    bfs(new int[]{i,j,0});

                    for (boolean[] vst: isVisited) {
                        Arrays.fill(vst, false);
                    }                    
                }                
            }
        }
        System.out.println(route);
    }
}