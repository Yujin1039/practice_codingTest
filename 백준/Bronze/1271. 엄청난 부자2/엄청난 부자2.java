import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger money = new BigInteger(st.nextToken());
        BigInteger creature = new BigInteger(st.nextToken());
        
        System.out.println(money.divide(creature));
        System.out.println(money.remainder(creature));
    }
}