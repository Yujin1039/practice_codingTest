import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static StringBuilder sb;
    static int move;
    
    static void shift(int num, int from, int to){
        move++;
        if(num == 1) {
            sb.append(from+" "+to+"\n");
            return;
        }

        shift(num-1, from, 6-from-to);
        sb.append(from+" "+to+"\n");
        shift(num-1, 6-from-to, to);

    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N > 20){
            System.out.println(BigInteger.valueOf(2).pow(N).subtract(BigInteger.ONE));
        } else {
            sb = new StringBuilder();
            move = 0;
            shift(N, 1, 3);
            System.out.println(move);
            System.out.println(sb.toString());
        }
    }
}