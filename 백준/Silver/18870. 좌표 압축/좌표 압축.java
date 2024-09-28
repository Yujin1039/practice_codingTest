import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] x = new int[N];
        int[] sortedX = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){            
            x[i] = Integer.parseInt(st.nextToken());
            sortedX[i] = x[i];
        }
        Arrays.sort(sortedX);

        Map<Integer,Integer> map = new HashMap<>();
        int idx = 0;
        for(int num:sortedX){
            if(!map.containsKey(num)) map.put(num,idx++);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            sb.append(map.get(x[i])).append(" ");
        }
        System.out.println(sb.toString());
	}
}