import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        PriorityQueue<int[]> jewel = new PriorityQueue<>((o1,o2)->{
            if(o1[0] == o2[0]){
                return o2[1]-o1[1];
            }
            return o1[0]-o2[0];
        });
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken()); // 무게
            int v = Integer.parseInt(st.nextToken()); // 가치
            jewel.add(new int[]{m,v});
        }
        
        Integer[] bag = new Integer[K];
        for(int i=0; i<K; i++){
            bag[i] = Integer.parseInt(br.readLine()); // 최대 저장 무게
        }
        Arrays.sort(bag);

        long maxValue = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);
        for(int i=0; i<K; i++){
            while (!jewel.isEmpty()) {            
                if(jewel.peek()[0] > bag[i]) break;               
                pq.add(jewel.poll()[1]);
            }            
            maxValue += pq.isEmpty() ? 0:pq.poll();
        }

        System.out.println(maxValue);
    }
}