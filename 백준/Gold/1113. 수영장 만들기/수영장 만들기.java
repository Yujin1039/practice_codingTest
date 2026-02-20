import java.util.*;
import java.io.*;

public class Main {   
    static int N;
    static int M;
    static int[][] space;
    static int min;
    static int max;
    static int[][] xy = new int[][]{{0,1,0,-1},{1,0,-1,0}};

    static int checkFourWay(int r, int c, int h){
        int area = 1;
        boolean pass = false;
        ArrayDeque<int[]> queue = new ArrayDeque<>();        
        queue.add(new int[]{r,c});
        space[r][c]++;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            
            for(int i=0; i<4; i++){
                int x = cur[0] + xy[0][i];
                int y = cur[1] + xy[1][i];
    
                if(x < 0 || x >= N || y < 0 || y >= M) {
                    pass = true;
                    continue;
                }

                if(space[x][y] == h){
                    queue.add(new int[]{x,y});
                    area++;
                    space[x][y]++;
                }
            }
        }
        return pass ? 0:area;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());                
        space = new int[N][M]; // 수영장 지을 공간       
        
        // 땅 상태 표시
        min = 9;
        max = 1;
        for(int i=0; i<N; i++){
            String cmd = br.readLine();
            for(int j=0; j<M; j++){
                int num = cmd.charAt(j)-'0';
                space[i][j] = num;
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
        }
        
        // 수영장 물 채우기
        int water = 0;
        for(int h=min; h<=max; h++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(space[i][j] == h){
                       water += checkFourWay(i, j, h);
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(water);
    }
}