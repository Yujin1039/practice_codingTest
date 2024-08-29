import java.io.*;
import java.util.*;

public class Main { 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] a = new int[1000001];
        a[2] = 1;
        a[3] = 1;

        for(int i=4;i<=num;i++){
            int j = num;
            if(i % 3 == 0){
                j = a[i/3];
            }
            if(i % 2 == 0){
                j = Math.min(a[i/2],j);
            }
            j = Math.min(a[i-1],j);  
            a[i] = 1 + j;
        }                   
        System.out.println(a[num]);
	}    
}