import java.util.*;
import java.io.*;

public class Main {      
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int[] first = new int[22];
        for(int i=1; i<=21; i++){
            if(i <= 1) first[i] = 500;
            else if(i <= 3) first[i] = 300; 
            else if(i <= 6) first[i] = 200; 
            else if(i <= 10) first[i] = 50;
            else if(i <= 15) first[i] = 30;
            else first[i] = 10;            
        }

        int[] second = new int[32];
        for(int i=1; i<=31; i++){
            if(i <= 1) second[i] = 512;
            else if(i <= 3) second[i] = 256; 
            else if(i <= 7) second[i] = 128; 
            else if(i <= 15) second[i] = 64;
            else second[i] = 32;         
        }

        for (int i=0; i<T; i++) {
            String[] record = br.readLine().split(" ");
            int fr = Integer.parseInt(record[0]);
            int sr = Integer.parseInt(record[1]);
            int fp = (fr > 0 && fr <= 21) ? first[fr]:0;
            int sp = (sr > 0 && sr <= 31) ? second[sr]:0;
            sb.append((fp+sp)*10000+"\n");
        }
        System.out.println(sb.toString());
    }
}