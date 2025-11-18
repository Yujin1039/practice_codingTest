import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());        
        MaxHeap maxHeap = new MaxHeap(N);
        

        for(int i=0; i<N; i++){
            int x = Integer.parseInt(br.readLine());
            
            if(x == 0){                
                sb.append(maxHeap.top()+"\n");
                if(maxHeap.top() != 0) maxHeap.delete();
            } else {
                maxHeap.insert(x);
            }
        }
        System.out.println(sb.toString());
    }
}

class MaxHeap{
    private int[] maxHeap;
    private int idx;

    public MaxHeap(int N){
        this.maxHeap = new int[N+1];
        this.idx = 1;
    }

    public int top(){
        return maxHeap[1];
    }
    
    public void insert(int x){       
        maxHeap[idx++] = x;

        for(int i=idx-1; i>1; i /= 2){
            if(maxHeap[i] > maxHeap[i/2]){
                swap(i, i/2);
            }
        }
    }

    public void delete(){
        maxHeap[1] = maxHeap[--idx];
        maxHeap[idx] = 0;
        
        int cur = 1;
        while(cur * 2 < idx){
            int target = cur*2;
            
            if(cur*2+1 < idx && maxHeap[cur*2] < maxHeap[cur*2+1]){
                target = cur*2+1;
            } 

            if(maxHeap[target] < maxHeap[cur]){
                return;
            }
            swap(cur, target);
            cur = target;
        }
    }
    
    public void swap(int prev, int next){
        int temp = maxHeap[prev];
        maxHeap[prev] = maxHeap[next];
        maxHeap[next] = temp;
    }
}