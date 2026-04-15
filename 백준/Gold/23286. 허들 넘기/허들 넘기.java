import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점
        int M = Integer.parseInt(st.nextToken()); // 간선
        int T = Integer.parseInt(st.nextToken()); // 연습

        // 최소높이 배열
        int[][] dist = new int[N+1][N+1];
        for(int i=0; i<=N; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0; // 시작도시 높이 초기화
        }
        
        // 각 간선별 높이 저장
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            
            dist[u][v] = Math.min(dist[u][v], h);
        }

        // 모든 노드 → 노드에 대해 최소 높이 저장
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    int prevHeight = Math.max(dist[i][k], dist[k][j]);
                    if(dist[i][j] > prevHeight){
                        dist[i][j] = prevHeight;
                    }
                }
            }
        }

        // T개만큼의 최소 거리 출력
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append((dist[s][e] == Integer.MAX_VALUE ? -1:dist[s][e])+"\n");
        }
        System.out.println(sb.toString());
    }
}