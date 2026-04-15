import java.io.*;
import java.util.*;

public class Main { 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
        int[] bj = new int[n];
        for(int i=0;i<n;i++){
            bj[i] = Integer.parseInt(st2.nextToken());
        }
        
        int min = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    int sum = bj[i] + bj[j] + bj[k];
                    if(sum > min && sum <= total) min = sum;
                }
            }
        }
        
        System.out.println(min);
	}    
}