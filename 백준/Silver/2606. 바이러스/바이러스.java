import java.util.*;
import java.io.*;

public class Main {
    public static int[] computers;

    static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if(a < b){
            computers[b] = a;            
        }else{
            computers[a] = b;
        }
    }
    
    static int findParent(int c){
        if(c != computers[c]){
            computers[c] =  findParent(computers[c]);
        }
        return computers[c];
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        
        computers = new int[N+1];
        for(int i=1;i<N+1;i++){
            computers[i] = i;
        }
        while(M > 0){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            unionParent(x,y);
            M--;
        }

        int networks = 0;
        for(int i=2;i<N+1;i++){
            if(computers[i] != 1){
                computers[i] = findParent(i);
            }
            if(computers[i] == 1) networks++;
        }
        System.out.println(networks);
    }
}