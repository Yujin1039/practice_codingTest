import java.util.*;
import java.io.*;

public class Main {   
    static int[] head, next, to;
    static int edgeCount = 0;
    
    static void addEdge(int from, int target) {
        to[edgeCount] = target;        // 현재 간선이 향하는 곳 저장
        next[edgeCount] = head[from];  // 이전의 head를 내 뒤로 연결
        head[from] = edgeCount;        // head를 현재 간선으로 업데이트
        edgeCount++;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        head = new int[N+1];
        Arrays.fill(head,-1);
        next = new int[M];
        to = new int[M];

        for(int i=0 ;i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            addEdge(b, a);
        }

        int[] computers = new int[N+1];
        boolean[] isVisited = new boolean[N+1];
        for (int i=1; i<=N; i++) {
            int visited = 0;
            Arrays.fill(isVisited, false);
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            
            stack.push(i);
            isVisited[i] = true;
            visited++;

            while (!stack.isEmpty()) { 
                int cmp = stack.pop();
                for(int j=head[cmp]; j != -1; j=next[j]){
                    int nextNode = to[j];
                    if(!isVisited[nextNode]){
                        isVisited[nextNode] = true;
                        stack.push(nextNode);                        
                        visited++;
                    }                        
                }                         
            } 
            computers[i] = visited;
        }
        int max = 0;
        for (int num : computers) {
            max = Math.max(num, max);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            if(computers[i] == max) sb.append(i+" ");
        }
        System.out.println(sb.toString());
    }
}