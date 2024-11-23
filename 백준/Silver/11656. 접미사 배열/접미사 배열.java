import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder word = new StringBuilder(br.readLine());
        int n = word.length();
        
        String[] suffix = new String[n];
        for(int i=0;i<n;i++){
            suffix[i] = word.substring(i,n);
        }
        Arrays.sort(suffix);
        System.out.println(Arrays.toString(suffix).replace("[","").replace("]","").replace(", ","\n"));
    }
}