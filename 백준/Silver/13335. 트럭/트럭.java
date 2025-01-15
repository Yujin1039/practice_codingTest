import java.util.*;
import java.io.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 지나갈 트럭 수
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int l = Integer.parseInt(st.nextToken()); // 다리 하중
        
        int[] truck = new int[n]; 
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            truck[i] = Integer.parseInt(st.nextToken());
        }
        
        int time = 1; int idx = 1;
        int bridgeSum = truck[0];
        Queue<int[]> bridge = new LinkedList<>();
        bridge.add(new int[]{truck[0],1});
        
        while(!bridge.isEmpty()){
            Iterator<int[]> iter = bridge.iterator();
            while(iter.hasNext()){
                int[] cur = iter.next();
                if(cur[1] == w) {
                    bridgeSum -= cur[0];
                    iter.remove();
                }else cur[1]++;
            }
            time++;
            if(bridge.size() < w && idx < n && bridgeSum + truck[idx] <= l){
                bridgeSum += truck[idx];
                bridge.add(new int[]{truck[idx++],1});
            }
        }
        System.out.println(time);
    }
}