import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s;
        while(!(s = br.readLine()).equals("0 0 0")){
            String[] tr = s.split(" ");
            int a = Integer.parseInt(tr[0]);
            int b = Integer.parseInt(tr[1]);
            int c = Integer.parseInt(tr[2]);
            
            int max = Math.max(a, Math.max(b,c));
            int squareSum = 0;
            if(max == a){
                squareSum = b*b + c*c;
            }else if(max == b){
                squareSum = a*a + c*c;
            }else{
                squareSum = a*a + b*b;
            }
            bw.write(max*max == squareSum ? "right\n" : "wrong\n");
        }        
        bw.flush();
        bw.close();
    }
}