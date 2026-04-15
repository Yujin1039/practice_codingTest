import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] max;
    static int[] result; 
    static boolean[] isVisited;
    static int[] maxRoute;
    
    static void dfs(int idx){
        if(idx == N) {
            int cur = 0;
            for (int i=0; i<N; i++) {
                for(int j=i+1; j<N; j++){
                    cur += max[result[i]][result[j]];
                }
            }
            if(cur > maxRoute[0]){
                maxRoute[0] = cur;
                maxRoute[1] = 1;
            } else if(cur == maxRoute[0]){
                maxRoute[1]++;
            }            
            return;
        }

        for(int i=1; i<=N; i++){
            if(!isVisited[i]){
                result[idx++] = i;
                isVisited[i] = true;
                dfs(idx);
                result[--idx] = 0;
                isVisited[i] = false;
            }
        }        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            max = new int[N+1][N+1];
            result = new int[N];
            isVisited = new boolean[N+1];
            maxRoute = new int[2];
            for(int j=0; j<M; j++){
                st = new StringTokenizer(br.readLine());
                int V = Integer.parseInt(st.nextToken());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                max[A][B] += V;
            }

            dfs(0);
            sb.append(maxRoute[0]+" "+maxRoute[1]+"\n");
        }
        System.out.println(sb.toString());
    }
}