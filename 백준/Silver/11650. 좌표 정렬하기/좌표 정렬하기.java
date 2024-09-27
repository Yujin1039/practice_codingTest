import java.io.*;
import java.util.*;

public class Main { 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());   

        int[][] input = new int[a][2];
		for(int i=0;i<a;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            input[i][0] = Integer.parseInt(st.nextToken());
            input[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(input,(c1,c2)-> {
            int d = Integer.compare(c1[0],c2[0]);
            if(d == 0){
                return Integer.compare(c1[1],c2[1]);
            }
            return d;
        });
        
        for(int[] sub: input){
            sb.append(sub[0]+" "+sub[1]).append("\n");
        }
        System.out.println(sb.toString());
	}   
}