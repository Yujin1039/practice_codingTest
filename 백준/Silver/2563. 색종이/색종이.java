import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
        boolean[][] square = new boolean[100][100];
        int squareSum = 0;
		
		for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            for(int j=h;j<h+10;j++){
                for(int k=w;k<w+10;k++){
                    if(!square[j][k]){
                        squareSum++;
                        square[j][k] = true;
                    }
                }
            }
        }
		System.out.println(squareSum);		
	}
}