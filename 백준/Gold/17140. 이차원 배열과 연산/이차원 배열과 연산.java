import java.io.*;
import java.util.*;
import java.util.Collections.*;

public class Main {    
    static int[][] arr;

    static int[] sort(int[] prev){
        Map<Integer, Integer> map = new HashMap<>();        
        for(int i=1; i<prev.length; i++){
            if(prev[i] == 0) continue;
            map.put(prev[i], map.getOrDefault(prev[i], 0) + 1);
        }
        List<int[]> cur = new ArrayList<int[]>();
        for(Integer key:map.keySet()){            
             cur.add(new int[]{key,map.get(key)});
        }

        Collections.sort(cur,(o1,o2) -> {
            int std = o1[1] - o2[1];                            
            if(std == 0){
             return o1[0]-o2[0];
            }
            return std;
        });
        Arrays.fill(prev, 0);
        for(int i=1; i<=cur.size()*2; i+=2){
            prev[i] = cur.get(i/2)[0];
            prev[i+1] = cur.get(i/2)[1];
        }
        prev[0] = cur.size()*2;

        return prev;
    }
    
    public static int R(int row, int column){
        for(int i=1; i<=row; i++){
            int[] cur = sort(arr[i]);  
            column = Math.max(column, cur[0]);
            for(int j=0; j<=cur[0]; j++){
                arr[i][j] = cur[j];
            }               
        }
        return column;
    }

    public static int C(int row, int column){
        for(int i=1; i<=column; i++){
            int[] prev = new int[101];
            for(int j=1; j<101; j++){
                prev[j] = arr[j][i];
            }
            int[] cur = sort(prev);  
            row = Math.max(row, cur[0]);

            for(int j=0; j<101; j++){
                if(j <= cur[0]) arr[j][i] = cur[j];
                else arr[j][i] = 0;
            }  
        }
        return row;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        arr = new int[101][101];
        
        for (int i=1; i<4; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = 3;
            for(int j=1; j<4; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int row = 3; int column = 3;
        while (arr[r][c] != k && time <= 100) {
            if(row >= column){
                column = R(row, column);
            } else {
                row = C(row, column);
            }
            time++;
        }

        System.out.println(time > 100 ? -1:time);
    }
}