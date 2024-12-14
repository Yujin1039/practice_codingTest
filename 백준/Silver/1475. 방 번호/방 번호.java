import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] number = new int[10];
        while(n > 0){
            number[n % 10]++;            
            n /= 10;
        }
        number[6] = number[9] = (number[6]+number[9]+1)/2;

        int cnt = 0;
        for(int i=0;i<10;i++){
            cnt = Math.max(cnt,number[i]);
        }
        System.out.println(cnt);
    }
}