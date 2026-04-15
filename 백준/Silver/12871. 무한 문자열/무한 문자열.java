import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String f = br.readLine();
        int slen = s.length();
        int flen = f.length();

        String lcdS = s.repeat(flen);
        String lcdF = f.repeat(slen);

        String[] arr1 = lcdS.split(lcdF);
        String[] arr2 = lcdF.split(lcdS);
        
        System.out.println((arr1.length == 0 || arr2.length == 0) ? 1:0);
    }
}