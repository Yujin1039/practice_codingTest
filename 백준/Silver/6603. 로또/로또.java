import java.util.*;
import java.io.*;

public class Main {  
    static StringBuilder sb;
    static int[] arr;
    static boolean[] isVisited;
    static int[] lotto;

    static void findComb(int start, int n, int[] lotto){
        if(n == 6){
            for(int i=0; i<6; i++){
                sb.append(lotto[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i=start; i<arr.length; i++) {
            if(!isVisited[i]){
                isVisited[i] = true;
                lotto[n] = arr[i];
                findComb(i+1, n+1, lotto);
                isVisited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cmd = br.readLine();
        sb = new StringBuilder();

        while (!cmd.equals("0")) {
            StringTokenizer st = new StringTokenizer(cmd);
            
            int n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            isVisited = new boolean[n];
            lotto = new int[6];
            findComb(0, 0, lotto);
            sb.append("\n");
            
            cmd = br.readLine();
        }

        System.out.println(sb.toString());
    }
}