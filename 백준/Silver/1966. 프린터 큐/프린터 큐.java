
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            String[] info = br.readLine().split(" ");
            int N = Integer.parseInt(info[0]);
            int M = Integer.parseInt(info[1]);
            
            StringTokenizer st = new StringTokenizer(br.readLine()); 
            Queue<int[]> queue = new LinkedList<>();
            int[] max = new int[N];
            
            for(int j=0; j<N; j++){
                int prior = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{prior, j});
                max[j] = prior;
            }
            Arrays.sort(max);
            int print = 0;
            int maxIdx = N-1;

            while (true) {
                int[] cur = queue.peek();
                if(cur[0] != max[maxIdx]){
                    queue.offer(queue.poll());
                } else{
                    maxIdx--;
                    print++;                                
                    queue.poll();
                    if(cur[1] == M) break;                    
                }                                
            } 
            sb.append(print+"\n");
        }
        System.out.println(sb.toString());
    }
}