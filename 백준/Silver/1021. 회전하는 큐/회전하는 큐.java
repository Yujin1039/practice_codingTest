import java.util.*;
import java.io.*;
    
public class Main {     
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for(int i=1;i<=n;i++){
            queue.add(i);
        }
        
        int operNum = 0;
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int node = Integer.parseInt(st.nextToken());
            int subOper = 0;
            while(queue.peek() != node){
                subOper++;
                queue.add(queue.remove());
            }
            operNum += Math.min(subOper,queue.size()-subOper);
            queue.remove();
        }        
        System.out.println(operNum);
    }
}