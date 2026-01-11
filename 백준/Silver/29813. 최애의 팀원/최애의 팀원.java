import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        ArrayDeque<String[]> queue = new ArrayDeque<>();
        for (int i=0; i<N; i++) {
            queue.add(br.readLine().split(" "));
        }

        while (queue.size() > 1) {
            String[] tm = queue.poll();
            int num = Integer.parseInt(tm[1]);
            for(int i=1; i<num; i++) queue.add(queue.poll());
            queue.poll();            
        }
        System.out.println(queue.poll()[0]);
    }
}