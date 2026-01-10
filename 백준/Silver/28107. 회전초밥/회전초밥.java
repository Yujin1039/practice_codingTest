import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 손님
        int M = Integer.parseInt(st.nextToken()); // 초밥
        
        List<ArrayDeque<Integer>> order = new ArrayList<>();
        for (int i=0; i<=200_000; i++) {
            order.add(new ArrayDeque<>());
        }
        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 먹을 메뉴 개수
            for(int j=0; j<n; j++){
                int ord = Integer.parseInt(st.nextToken());
                order.get(ord).offer(i);
            }
        }

        // 실제 나가는 초밥
        PriorityQueue<Integer> sushi = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            sushi.offer(Integer.parseInt(st.nextToken()));
        }

        // 손님별 먹은 초밥 수
        int[] eatingNum = new int[N+1];
        while (!sushi.isEmpty()) {
            int sNum = sushi.poll();
            ArrayDeque<Integer> ordList = order.get(sNum);
            if(!ordList.isEmpty()){
                int person = ordList.poll();
                eatingNum[person]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
            sb.append(eatingNum[i]+" ");
        }
        System.out.println(sb.toString());
    }
}