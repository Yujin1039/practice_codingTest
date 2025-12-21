import java.io.*;
import java.util.*;

public class Main {  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] basket = new int[N+1];
        for(int i=1; i<=N; i++){
            basket[i] = i;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int n=0; n<M; n++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            for(int m=i; m<=j; m++){
                queue.add(basket[m]);
            }

            int mid = basket[k];
            while (queue.peek() != mid) {
                queue.add(queue.poll());
            }

            for(int m=i; m<=j; m++){
                basket[m] = queue.poll();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; i++) {
            sb.append(basket[i]+" ");
        }
        System.out.println(sb.toString());
    }
}