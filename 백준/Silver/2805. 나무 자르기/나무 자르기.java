import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        
        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i=0;i<N;i++){
            int tree = Integer.parseInt(st.nextToken());
            trees[i] = tree;
            if(tree > max) max = tree;
        }

        int min = 0;               
        while(max >= min){
            int mid = (min+max)/2;  
            long meter = 0;            
            for(int tree:trees){
                meter += tree > mid ? tree-mid:0;
            }            
            if(meter >= M){
                min = mid+1;
            }else if(meter < M){
                max = mid-1;
            }
        }        
        System.out.println(max);
	}
}