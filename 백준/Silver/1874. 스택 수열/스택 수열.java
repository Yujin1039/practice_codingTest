import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine())+1;
        int prev = 1;
        int[] stack = new int[size];

        for(int i=0; i<size-1; i++){
            int num = Integer.parseInt(br.readLine());
            int cur = prev;

            while(cur <= num){
                if(stack[cur] == 0) {
                    stack[cur] = cur;
                    sb.append("+\n");
                } 
                cur++;    
            }
            
            while(cur > num){
                cur--;
                if(stack[cur] == num) {
                    stack[cur] = -1;
                    sb.append("-\n");
                } else if(stack[cur] >  num){
                    System.out.println("NO");
                    System.exit(0);
                }
            } 
            prev = num;
        }
        System.out.println(sb.toString());
    }
}