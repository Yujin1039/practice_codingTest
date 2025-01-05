import java.util.*;
import java.io.*;

public class Main { 
    private static int[][] xy = new int[][]{{1,0,-1,0},{0,1,0,-1}};
    private static char[][] layout;
    private static boolean[] isVisited;
    private static int[] sList;
    private static char[] tmp;
    private static int cases = 0;

    static int bfs(){
        LinkedList<Integer> list = new LinkedList<>();
        boolean[] isChecked = new boolean[25];
        list.add(sList[0]);
        isChecked[sList[0]] = true;
        while(!list.isEmpty()){
            int cur = list.poll();
            for(int i=0;i<4;i++){
                int x = cur/5 + xy[0][i];
                int y = cur%5 + xy[1][i];
                int idx = 5*x+y;
                
                if(x < 0 || x >= 5 || y < 0 || y >= 5 || isChecked[idx]) continue;

                isChecked[idx] = true;
                for(int a:sList){
                    if(a == idx) list.add(idx);
                }                
            }
        }
        for(int i=0;i<7;i++) {
            if(!isChecked[sList[i]]) return 0;
        }
        return 1;
    }
    static void findPrincess(int start,int len){
        if(len == 7){
            int tmpc = 0;
            for(char c:tmp){
                if(c == 'S') tmpc++;
            }
            if(tmpc >= 4) cases += bfs();
            return;            
        }
        for(int i=start;i<25;i++){
            if(!isVisited[i]) {
                int j = i/5; int k = i%5;
                tmp[len] = layout[j][k];
                sList[len] = i;
                isVisited[i] = true;
                findPrincess(i,len+1);
                isVisited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        layout = new char[5][5];
        for(int i=0;i<5;i++){
            layout[i] = br.readLine().toCharArray();
        }
        tmp = new char[7];
        isVisited = new boolean[25];
        sList = new int[7];
        findPrincess(0,0);
        System.out.println(cases);
    }
}