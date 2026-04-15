import java.util.*;
import java.io.*;

public class Main {    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(br.readLine());
        long max = num;
        long min = 0;

        while (max > min) {
            long mid = (max+min)/2;
            if(Math.pow(mid,2) >= num){
                max = mid;                
            } else {
                min = mid+1;
            }
        }
        System.out.println(max);
    }
}