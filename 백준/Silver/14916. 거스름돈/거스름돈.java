import java.io.*;
import java.util.*;

public class Main {        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int five = n/5; int two = (n%5)/2;
        if((five*5 + two*2) != n){
            five--;
            two = ((n%5)+5)/2;
        }
        System.out.println((five < 0 || two < 0) ? -1:five+two);
    }
}