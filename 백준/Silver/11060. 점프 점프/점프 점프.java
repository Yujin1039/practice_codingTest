import java.util.*;
import java.io.*;

public class Main {    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] maze = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            maze[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] isVisited = new boolean[n+1];
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1,0});

        int ans = -1;
        br_point:
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int num = arr[0];
            int vit = arr[1];
            if(num == n){
                ans = vit;
                break br_point;
            }
            
            for(int i=1; i <= maze[num]; i++){
                if(num+i <= n && !isVisited[num+i]){                   
                    queue.add(new int[]{num+i, vit+1});
                    isVisited[num+i] = true;
                }
            }
        }        
        System.out.println(ans);
    }
}