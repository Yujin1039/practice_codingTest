import java.util.*;
import java.io.*;
import java.util.Collections.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());

            if(maxHeap.size() == 0){
                maxHeap.offer(num);
            } else if(maxHeap.size() == minHeap.size()){
                if(num < minHeap.peek()) maxHeap.offer(num);
                else {
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(num);
                }
            } else {
                if(minHeap.size() == 0 && num >= maxHeap.peek()){
                    minHeap.offer(num);
                }else if((minHeap.size() == 0 && num < maxHeap.peek()) || num <= maxHeap.peek()){
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(num);
                } else {
                    minHeap.offer(num);
                }
            }
            sb.append(maxHeap.peek()+"\n");
        }
        System.out.println(sb.toString());        
    }
}