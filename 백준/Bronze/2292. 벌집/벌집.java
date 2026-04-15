import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int a = Integer.parseInt(br.readLine());
        int m = 1;
        
        for(int n=1;n>0;n += 6*(m-1)){
            if(n >= a){
                System.out.println(m);
                break;
            }
            m++;
        }
    } 
}