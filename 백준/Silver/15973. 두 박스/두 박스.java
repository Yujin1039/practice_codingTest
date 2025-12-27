import java.util.*;
import java.io.*;

// POINT, LINE, FACE, NULL
public class Main {   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sx1 = Integer.parseInt(st.nextToken());
        int sy1 = Integer.parseInt(st.nextToken());
        int ex1 = Integer.parseInt(st.nextToken());
        int ey1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int sx2 = Integer.parseInt(st.nextToken());
        int sy2 = Integer.parseInt(st.nextToken());
        int ex2 = Integer.parseInt(st.nextToken());
        int ey2 = Integer.parseInt(st.nextToken());

        if(ey1 < sy2 || ex1 < sx2 || sy1 > ey2 || sx1 > ex2){
            System.out.println("NULL");
        } else if((ex1 == sx2 && ey1 == sy2) || (ex1 == sx2 && sy1 == ey2) || (sx1 == ex2 && sy1 == ey2) || (sx1 == ex2 && ey1 == sy2)){
            System.out.println("POINT");
        } else if(ey1 == sy2 || ex1 == sx2 || sy1 == ey2 || sx1 == ex2){
            System.out.println("LINE");
        } else {
            System.out.println("FACE");
        }
    }
}