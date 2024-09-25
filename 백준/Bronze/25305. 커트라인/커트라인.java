import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int prize = Integer.parseInt(st.nextToken());

        int[] score = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            score[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(score);        
        System.out.println(score[n-prize]);
	}
}