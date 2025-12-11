import java.util.*;
import java.io.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        List<ArrayList<int[]>> list = new ArrayList<>();
        for(int i=0; i<=D; i++){
            list.add(new ArrayList<>());
        }
        for(int i=0; i<N; i++){
            st =  new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            
            if(end-start-dis > 0 && end <= D) list.get(start).add(new int[]{end,dis});
        }
        
        int[] dis = new int[D+1];
        Arrays.fill(dis,D);
        dis[0] = 0;
        for(int i=0; i<=D; i++){
            if(i > 0) dis[i] = Math.min(dis[i], dis[i-1]+1);
            
            if(list.get(i).size() != 0) {
                for(int[] nxt:list.get(i)){
                    dis[nxt[0]] = Math.min(dis[nxt[0]],dis[i]+nxt[1]); 
                }
            }
        }
        System.out.println(dis[D]);       
    }
}