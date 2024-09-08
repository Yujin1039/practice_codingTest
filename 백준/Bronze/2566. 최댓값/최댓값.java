import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        StringBuilder sb = new StringBuilder();
             
        int max = 0; int w = 0; int h = 0;
        for(int i=0;i<9;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                int num = Integer.parseInt(st.nextToken());
                if(num >= max){
                    max = num;
                    h = i+1;
                    w = j+1;
                }
            }
        }

        sb.append(max).append("\n").append(h+" "+w);
        System.out.println(sb);
    }
}