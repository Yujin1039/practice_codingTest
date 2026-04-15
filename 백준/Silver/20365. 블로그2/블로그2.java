import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String result = br.readLine();

        int blue = 0;
        int red = 0;
        char prev = ' ';
        for(int i=0; i<result.length(); i++){
            char color = result.charAt(i);
            if(color != prev){
                if(color == 'B') blue++;
                else red++;
            }
            prev = color;
        }

        System.out.println(Math.min(blue,red)+1);
    }
}