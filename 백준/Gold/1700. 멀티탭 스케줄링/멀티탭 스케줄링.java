import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] eleDevice = new int[K];
        int[][] map = new int[K+1][K+1];
        for(int i=0; i<K; i++){
            eleDevice[i] = Integer.parseInt(st.nextToken());
            int cur_idx = Math.max(map[eleDevice[i]][0], 1);
            map[eleDevice[i]][cur_idx] = i;
            map[eleDevice[i]][0] = cur_idx+1;
        }
        for(int i=0; i<K; i++){
            map[i][0] = 1;
        }

        List<Integer> plug = new ArrayList<>();
        int exchange = 0;
        for(int i=0; i<K; i++){
            map[eleDevice[i]][0]++;
            if(plug.indexOf(eleDevice[i]) != -1) continue;
            
            if(plug.size() < N) {                
                plug.add(eleDevice[i]);                
            } else {
                int idx = 0;
                int maxIdx = N;
                for(int j=0; j<plug.size(); j++){
                    int map_idx = map[plug.get(j)][0];
                    if(map[plug.get(j)][map_idx] == 0){
                        idx = j;
                        break;
                    } else if(map[plug.get(j)][map_idx] > maxIdx){
                        maxIdx = map[plug.get(j)][map_idx];
                        idx = j;
                    }
                }
                plug.set(idx, eleDevice[i]);                
                exchange++;
            }            
        }
        System.out.println(exchange);
	}
}