import java.io.*;
import java.util.*;

public class Main{
    public static boolean isPrimeNum(int a){
        if( a != 2 && a % 2 == 0 || a == 1) return false;
        for(int i=1;i<=Math.sqrt(a);i += 2){
            if(i != 1 && a % i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int num = 0;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        while(st.hasMoreTokens()){
            int x = Integer.parseInt(st.nextToken());
            if(isPrimeNum(x)){
                num++;
            }
        }
        System.out.println(num);
    }
}