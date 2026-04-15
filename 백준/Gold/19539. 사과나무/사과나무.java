import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());        
        int sum = 0;
        int tree2 = 0; int tree1 = 0;
        
        for(int i=0; i<N; i++){
            int tree = Integer.parseInt(st.nextToken());
            sum += tree;
            tree2 += tree/2;
            tree1 += tree%2;
        }

        if(sum % 3 != 0 || tree2 < tree1){
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }
}