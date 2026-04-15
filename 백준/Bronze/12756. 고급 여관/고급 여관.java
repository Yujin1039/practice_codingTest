import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int aA = Integer.parseInt(st.nextToken());
        int aL = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int bA = Integer.parseInt(st.nextToken());
        int bL = Integer.parseInt(st.nextToken());
        
        while (aL > 0 && bL > 0) {
            aL -= bA;
            bL -= aA;
        }

        System.out.println(aL <= 0 && bL <= 0 ? "DRAW":aL <= 0 ? "PLAYER B":"PLAYER A");
    }
}