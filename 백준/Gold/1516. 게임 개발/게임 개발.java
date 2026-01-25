import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] f_build = new int[n+1];
        int[] buildings = new int[n+1];
        List<List<Integer>> indegree = new ArrayList<>();
        List<List<Integer>> outdegree = new ArrayList<>();
        for(int i=0; i<=n; i++){
            indegree.add(new ArrayList<>());
            outdegree.add(new ArrayList<>());
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int branch = Integer.parseInt(st.nextToken());
            f_build[i] = f;
            
            if(branch == -1){                
                queue.add(i);
            } else {
                while (branch != -1) {
                    indegree.get(i).add(branch);
                    outdegree.get(branch).add(i);
                    branch = Integer.parseInt(st.nextToken());
                }
                
            }
        }

        int[] indegree_num = new int[n+1];
        for(int i=1; i<=n; i++){
            indegree_num[i] = indegree.get(i).size();
        }

        while (!queue.isEmpty()) {
            int num = queue.poll();
            buildings[num] += f_build[num];
            
            List<Integer> list = outdegree.get(num);
            for(int next:list){
                indegree_num[next]--;                
                if(indegree_num[next] == 0) {
                    int max = buildings[num];
                    
                    List<Integer> list2 = indegree.get(next);
                    for(int nt:list2){
                        max = Math.max(buildings[nt], max);
                    }
                    buildings[next] += max;
                    queue.add(next);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            sb.append(buildings[i]).append("\n");
        }
        System.out.println(sb.toString());        
    }
}