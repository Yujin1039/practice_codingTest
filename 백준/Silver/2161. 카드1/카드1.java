
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> cards = new ArrayDeque<>();

        for(int i=1; i<n+1; i++){
            cards.offer(i);
        }

        while (cards.size() > 1) {
            sb.append(cards.poll()+" ");
            cards.offer(cards.poll());
        }
        sb.append(cards.poll());
        
        System.out.println(sb.toString());
    }
}