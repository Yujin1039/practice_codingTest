import java.io.*;
import java.util.*;

public class Main { 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringBuilder sb = new StringBuilder();
        
        int a = Integer.parseInt(br.readLine());
        int[] arr = new int[a];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<a;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        br.readLine();
        st = new StringTokenizer(br.readLine()," ");
        
        while(st.hasMoreTokens()){
            int value = Integer.parseInt(st.nextToken());
            int idx = Arrays.binarySearch(arr,value);
            sb.append(idx >= 0 ? "1\n":"0\n");
        }

        System.out.println(sb.toString());
	}    
}