import java.io.*;
import java.util.*;

public class Main {	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int xmax = Integer.parseInt(st.nextToken());
        int xmin = xmax;
        int ymax = Integer.parseInt(st.nextToken());
        int ymin = ymax;

        for(int i=n;i > 1;i--){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            xmax = x > xmax ? x:xmax;
            xmin = x < xmin ? x:xmin;
            int y = Integer.parseInt(st.nextToken());
            ymax = y > ymax ? y:ymax;
            ymin = y < ymin ? y:ymin;            
        }
    	System.out.println((xmax-xmin)*(ymax-ymin));		            
	}
}