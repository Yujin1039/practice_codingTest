import java.util.*;
import java.io.*;

public class Main {    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int dasom = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1,o2) -> o2-o1);
        for (int i=0; i<n; i++) {
            int votes = Integer.parseInt(br.readLine());
            if(i == 0) {
                dasom = votes;
            } else {
                queue.add(votes);
            }
        }

        int ans = 0;
        while (!queue.isEmpty() && dasom <= queue.peek()) {
            ans++;
            dasom++;
            queue.add(queue.poll()-1);
        }
        System.out.println(ans);
    }
}