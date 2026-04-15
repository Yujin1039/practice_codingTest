import java.io.*;
import java.util.*;
import java.math.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> circle = new ArrayDeque<>();
        for(int i=1; i<=n; i++){
            circle.offer(i);
        }

        int round = 1;
        while(circle.size() > 1){
            long move = ((long)round*round*round)%circle.size();
            for(int i=1; i<move; i++){
                circle.offer(circle.poll());    
            }
            if(move > 0) circle.poll();
            else circle.pollLast();
            round++;
        }
        System.out.println(circle.peek());
    }
}