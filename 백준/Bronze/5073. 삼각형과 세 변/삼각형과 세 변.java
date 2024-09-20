import java.io.*;
import java.util.*;

/*
세 각의 크기가 모두 60이면, Equilateral
세 각의 합이 180이고, 두 각이 같은 경우에는 Isosceles
세 각의 합이 180이고, 같은 각이 없는 경우에는 Scalene
세 각의 합이 180이 아닌 경우에는 Error
*/

public class Main {
    public static String triangleType(int a, int b, int c){
        int max = Math.max(Math.max(a,b),c);
        if(max*2 >= a+b+c){
            return "Invalid";
        }else if(a == b && b == c && c == a){
            return "Equilateral";
        }else if(a != b && b != c && c != a){
            return "Scalene";
        }
        return "Isosceles";
    }
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String tri = br.readLine();

        while(!tri.equals("0 0 0")){
            StringTokenizer st = new StringTokenizer(tri);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            sb.append(triangleType(a,b,c)).append("\n");
            tri = br.readLine();
        }        
    	System.out.println(sb);		            
	}
}