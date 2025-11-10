import java.util.*;
import java.io.*;

public class Main {
    //static int[][] xy = {{1, 0, -1, 0}, {0, 1, 0, -1}}; 
    static int members, personE;
    static int[][] family;
    static int[][] distance;
    static boolean[] isVisited;
    static Queue<int[]> queue;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        members = Integer.parseInt(br.readLine());
        family = new int[members+1][members+1];
        distance = new int[members+1][members+1];
        isVisited = new boolean[members+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        int personS = Integer.parseInt(st.nextToken());
        personE = Integer.parseInt(st.nextToken());
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()); 
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            family[start][end] = 1;
            family[end][start] = 1;
        }

        queue = new LinkedList<>();
        queue.add(new int[]{personS,0});
        isVisited[personS] = true;

        System.out.println(bfs());
        
    }
    
    private static int bfs(){
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int personN = temp[0];
            int kinship = temp[1];

            for(int i=1; i<members+1; i++){
                if(!isVisited[i] && family[personN][i] == 1){
                    if(i == personE){
                        return kinship+1;
                    }
                    distance[personN][i] = kinship+1;
                    distance[i][personN] = kinship+1;
                    isVisited[i] = true;
                    queue.add(new int[]{i,kinship+1});
                }
            }
        } 
        return -1;
    } 
}