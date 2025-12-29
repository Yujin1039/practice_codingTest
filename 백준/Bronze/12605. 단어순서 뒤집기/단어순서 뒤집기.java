import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i=1; i<=N; i++){
            String[] letters = br.readLine().split(" ");
            StringBuilder tmp = new StringBuilder();
            sb.append("Case #"+i+": ");
            for (int j=letters.length-1; j>=0; j--) {
                sb.append(letters[j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());       
    }
}