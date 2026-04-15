import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        

        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            pq.add(x);
        }

        long sum = 0;
        while (pq.size() > 1) {
            int temp = pq.poll()+pq.poll();
            sum += (long) temp;
            pq.add(temp);
        }
        System.out.println(sum);
    }
}