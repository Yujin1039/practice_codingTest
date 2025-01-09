import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alphabet = new int[26];
        String str = br.readLine();

        for(int i=0;i<str.length();i++){
            alphabet[str.charAt(i)-97]++;
        }
        System.out.println(Arrays.toString(alphabet).replace("[","").replace("]","").replace(",",""));
    }
}