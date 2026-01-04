import java.util.*;
import java.io.*;

public class Main {   
    static String bfs(int sX, int sY, int eX, int eY, List<int[]> list){
        boolean[] isVisited = new boolean[list.size()];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sX, sY});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i=0; i<list.size(); i++) {
                if(!isVisited[i]){
                    int x = list.get(i)[0];
                    int y = list.get(i)[1];
                    int d = Math.abs(x-cur[0]) + Math.abs(y-cur[1]);
                    
                    if(d <= 1000){
                        if(x == eX && y == eY) return "happy\n";
                        queue.offer(new int[]{x,y});
                        isVisited[i] = true;
                    }
                }
            }            
        }
        return "sad\n";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<T; i++){
            int cvStore = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sX = Integer.parseInt(st.nextToken());
            int sY = Integer.parseInt(st.nextToken());

            List<int[]> list = new ArrayList<>();
            for(int j=0; j<cvStore; j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                
                list.add(new int[]{x,y});
            }

            st = new StringTokenizer(br.readLine());
            int eX = Integer.parseInt(st.nextToken());
            int eY = Integer.parseInt(st.nextToken());
            list.add(new int[]{eX,eY});

            sb.append(bfs(sX, sY, eX, eY, list));
        }
        System.out.println(sb.toString());
    }
}