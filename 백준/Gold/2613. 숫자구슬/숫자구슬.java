import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] nb = new int[N];
        int min = 0; int max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int bead = Integer.parseInt(st.nextToken());
            nb[i] = bead;
            min = bead > min ? bead:min;
            max += bead;
        }

        int ans = 0;
        while(min <= max){ 
            int mid = (min+max)/2;
            int group = 1; int temp = 0;
            
            for(int i=0; i<N; i++){
                if(temp+nb[i] > mid){
                    group++;
                    temp = nb[i];
                } else {
                    temp += nb[i];
                }
            }
            if(group <= M){
                ans = mid;
                max = mid-1;
            } else {                
                min = mid+1;
            }            
        }

        
        List<Integer> grpN = new ArrayList<>();
        int size = 0; int temp = 0;
        for(int i=0; i<N; i++){
            if(temp+nb[i] > ans){
                grpN.add(size);
                size = 1;
                temp = nb[i];                
            } else {
                temp += nb[i];
                size++;
            }
        }  
        if(size > 0) grpN.add(size);

        if(grpN.size() < M){
            for(int i=grpN.size()-1; i>=0; i--){
                if(grpN.get(i) != 1){
                    while (grpN.size() < M && grpN.get(i) > 1) {
                        grpN.set(i, grpN.get(i)-1);
                        grpN.add(i+1, 1);
                    }                    
                    if(grpN.size() == M) break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(ans+"\n");
        for(int num:grpN){
            sb.append(num+" ");
        }
        System.out.println(sb.toString());
    }
}