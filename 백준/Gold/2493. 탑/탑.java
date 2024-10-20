import java.util.*;
import java.io.*;
    
public class Main {        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());         
        ArrayDeque<int[]> tower = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 1;
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()){
            int height = Integer.parseInt(st.nextToken());

            while(!tower.isEmpty() && height > tower.peekLast()[0]){
                tower.removeLast();
            }
            if(tower.isEmpty()){
                sb.append("0 ");                    
            }else{
                sb.append(tower.peekLast()[1]+" ");
            }
            tower.add(new int[]{height,idx++});   
        }                 
        System.out.println(sb.toString());
    }
}