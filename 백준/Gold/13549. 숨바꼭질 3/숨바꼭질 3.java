import java.util.*;
import java.io.*;

public class Main {    
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수빈 위치
        int K = Integer.parseInt(st.nextToken()); // 동생 위치

        int[] dis = new int[200_002]; // 최단시간 배열
        Arrays.fill(dis,INF);

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        dis[N] = 0;
        queue.add(new int[]{0,N});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int start = cur[1];

            if(start*2 < dis.length && dis[start*2] > dis[start]) {
                dis[start*2] = dis[start];
                queue.addFirst(new int[]{0,start*2});
            }
            if(start > 0 && dis[start-1] > dis[start]+1) {
                dis[start-1] = dis[start]+1;
                queue.add(new int[]{1,start-1});
            }
            if(start < dis.length-1 && dis[start+1] > dis[start]+1) {
                dis[start+1] = dis[start]+1;
                queue.add(new int[]{1,start+1});
            }   
        }        
        System.out.println(dis[K]);
    }
}