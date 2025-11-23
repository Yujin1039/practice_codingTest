import java.util.*;
import java.io.*;
import java.util.Collections.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 보석점 수
        int K = Integer.parseInt(st.nextToken()); // 가방 수

        int[][] jewels = new int[N][2];        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            jewels[i][0] = M;
            jewels[i][1] = V;
        }
        Arrays.sort(jewels, (arr1, arr2) -> Integer.compare(arr1[0],arr2[0]));

        int[] bags = new int[K];
        for(int i=0; i<K; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        long value = 0;
        PriorityQueue<Integer> info = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        for(int i=0; i<K; i++){
            for(int j=idx; j<N; j++){                
                if(bags[i] >= jewels[j][0]){
                    info.offer(jewels[j][1]);
                } else {
                    break;
                }
              idx++;
            }            
            if(!info.isEmpty()) value += info.poll();
        }
        System.out.println(value);        
    }
}