import java.util.*;
import java.io.*;

public class Main {
    static boolean isC(int x1, int y1, int p1, int q1, int x2, int y2, int p2, int q2){
        if(x2 == p1 && y2 == q1){
            return true;
        } else if(p2 == x1 && y2 == q1){
            return true;
        } else if(x2 == p1 && q2 == y1){
            return true;
        } else if(p2 == x1 && q2 == y1){
            return true;
        } else {
            return false;
        }        
    }

    static boolean isB(int x1, int y1, int p1, int q1, int x2, int y2, int p2, int q2){
        if(p2 > x1 && x2 < p1 && q2 == y1){
            return true;
        } else if(p2 > x1 && x2 < p1 && y2 == q1){
            return true;
        } else if(q2 > y1 && y2 < q1 && p2 == x1){
            return true;
        } else if(q2 > y1 && y2 < q1 && x2 == p1){
            return true;
        } else {
            return false;
        }
    }

    static boolean isD(int x1, int y1, int p1, int q1, int x2, int y2, int p2, int q2){
        if(q2 < y1 || y2 > q1 || p2 < x1 || x2 > p1){
            return true;
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int i=0; i<4; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());

            if(isC(x1, y1, p1, q1, x2, y2, p2, q2)) sb.append("c\n");
            else if(isB(x1, y1, p1, q1, x2, y2, p2, q2)) sb.append("b\n");
            else if(isD(x1, y1, p1, q1, x2, y2, p2, q2)) sb.append("d\n");
            else sb.append("a\n");
        }
        
        System.out.println(sb.toString());
    }
}