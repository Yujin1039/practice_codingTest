import java.io.*;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 인접 리스트 초기화
        List<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        
        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            adj.get(A).add(new int[]{C,B}); // 0: 비용, 1: 도착점
            adj.get(B).add(new int[]{C,A});
        }
        
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 탐색 시작 지점
        int end = Integer.parseInt(st.nextToken()); // 탐색 종료 지점

        int max = 1_000_000_000;
        int min = 1;
        
        while (min < max) {
            int mid = (max+min+1)/2;;
            boolean isEnd = false;

            boolean[] isVisited = new boolean[N+1];
            isVisited[start] = true;
            queue.offer(start);
            
            while (!queue.isEmpty()) {
                int cur = queue.poll();

                if(cur == end) {
                    isEnd = true;
                    break;
                }
                
                for(int[] arr:adj.get(cur)){
                    if(arr[0] >= mid && !isVisited[arr[1]]) {
                        isVisited[arr[1]] = true;
                        queue.add(arr[1]);
                    }
                }               
            }
            if(isEnd){
                min = mid;
            } else {
                max = mid-1;
            }
            queue.clear();
        }  
        
        System.out.println(min);
    }
}