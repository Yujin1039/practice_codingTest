
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
            List<Integer> max = new LinkedList<>();
            
            for(int j=0; j<N; j++){
                int prior = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{prior, j});
                max.add(prior);
            }
            max.sort(Comparator.reverseOrder());
            int print = 0;

            while (queue.peek()[1] != M || queue.peek()[0] != max.get(0)) {
                while (queue.peek()[0] != max.get(0)) {
                    queue.offer(queue.poll());
                }
                max.remove(0);
                if(queue.peek()[1] == M) break;
                print++;                                
                queue.poll();                
            } 
            print++;
            sb.append(print+"\n");
        }
        System.out.println(sb.toString());
    }
}