import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Map<Integer, ArrayDeque<Integer>> map = new HashMap<>();

        long sum = 0;
        for (int i=0; i<N; i++) {
            int len = br.readLine().length();
            ArrayDeque<Integer> queue = map.getOrDefault(len, new ArrayDeque<Integer>());
            while (!queue.isEmpty() && i - queue.peek() > K) {
                queue.poll();
            }
            sum += queue.size();
            queue.offer(i);
            map.put(len, queue);
        }
        System.out.println(sum);
    }
}