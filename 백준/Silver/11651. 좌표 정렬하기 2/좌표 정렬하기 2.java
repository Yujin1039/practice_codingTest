import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] xy = new int[N][2];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xy[i][0] = x; xy[i][1] = y;
        }

        Arrays.sort(xy,
            (o1,o2) -> {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }else{
                    return o1[1] - o2[1];
                }            
        });

        StringBuilder sb = new StringBuilder();
        for(int[] j:xy){
            sb.append(j[0]).append(" ").append(j[1]).append("\n");
        }

        System.out.println(sb.toString());
	}
}