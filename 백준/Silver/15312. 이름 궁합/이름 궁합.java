import java.util.*;
import java.io.*;

public class Main {
    static int[] stroke = new int[]{3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String jong = br.readLine();
        String her = br.readLine();
        
        int n = jong.length()*2;
        int[] chemi = new int[n];
        for(int i=0; i<n; i++){
            if(i % 2 == 0) chemi[i] = stroke[jong.charAt(i/2)-'A'];
            else chemi[i] = stroke[her.charAt(i/2)-'A'];
        }

        for(int i=1; i<n-1; i++){
            for(int j=0; j<n-i; j++){
                chemi[j] = (chemi[j] + chemi[j+1]) % 10;
            }
            chemi[n-i] = 0;
        }
        
        System.out.println(chemi[0]+""+chemi[1]);       
    }
}