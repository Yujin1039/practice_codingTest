import java.util.*;
import java.io.*;

public class Main {    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Long> queue = new PriorityQueue<Long>((o1,o2) -> Long.compare(o1,o2));
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            queue.add(Long.parseLong(st.nextToken()));
        }

        for (int i=0; i<m; i++) {
            long x = queue.poll(); long y = queue.poll();
            queue.add(x+y);
            queue.add(x+y);
        }

        long sum = 0;
        while (!queue.isEmpty()) {
            sum += queue.poll();
        }
        System.out.println(sum);
    }
}