import java.util.*;
import java.io.*;

public class Main { 
    static int m;
    static ArrayList<int[]> houseList;
    static ArrayList<int[]> chicken;
    static boolean[] isVisited;
    static int distance;
    
    static void findChickenHouse(int cnt, int ch){
        if(cnt == m){
            int tmp = 0;
            for(int[] house:houseList){
                int pre = Integer.MAX_VALUE;
                for(int i=0;i<chicken.size();i++){
                    if(isVisited[i]){
                        int[] cur = chicken.get(i);                    
                        pre = Math.min(Math.abs(house[0]-cur[0]) + Math.abs(house[1]-cur[1]),pre);
                    }
                }
                tmp += pre;
            }
            distance = Math.min(distance,tmp);
            return;
        }
        for(int i=ch;i<chicken.size();i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                findChickenHouse(cnt+1,i+1);
                isVisited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] city = new int[n][n];
        m = Integer.parseInt(st.nextToken());

        houseList = new ArrayList<>();
        chicken = new ArrayList<>();
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int num = Integer.parseInt(st.nextToken());
                if(num == 1) houseList.add(new int[]{i,j});
                else if(num == 2) chicken.add(new int[]{i,j});
                city[i][j] = num;
            }
        }
        isVisited = new boolean[chicken.size()];
        distance = Integer.MAX_VALUE;
        findChickenHouse(0,0);
        
        System.out.println(distance);
    }
}