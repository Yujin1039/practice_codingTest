import java.io.*;
import java.util.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        int N = Integer.parseInt(br.readLine());
        int[] cage = new int[N];

        cage[0] = 3;
        if(N > 1) cage[1] = 7;
        
        for(int i=2; i<N; i++){
            cage[i] = (cage[i-2] + cage[i-1]*2) % 9901;
        }
        System.out.println(cage[N-1]);
    }
}