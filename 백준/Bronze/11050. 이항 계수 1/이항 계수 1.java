import java.io.*;
import java.util.*;

public class Main {
    public static int factorial(int z){
        if(z > 1){
            return z * factorial(z-1);
        }else{
            return 1;
        }
    }
    public static int binoCoefficient(int x,int y){    
        if(y > 0){
            return x *  binoCoefficient(x-1,y-1);
        }else{
            return 1;
        }
    }
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());	
        int b = Integer.parseInt(st.nextToken());

        System.out.println(binoCoefficient(a,b)/factorial(b));
	}
}