import java.util.*;
import java.io.*;

public class Main {
    private static int[] cups;
    
    public static void swap(int f, int s){
        int tmp = cups[f];
        cups[f] = cups[s];
        cups[s] = tmp;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String cmd = br.readLine();
        cups = new int[]{1,0,0};

        for(int i=0; i<cmd.length(); i++){
            if(cmd.charAt(i) == 'A'){
                swap(0,1);
            } else if(cmd.charAt(i) == 'B'){
                swap(1,2);
            } else {
                swap(0,2);
            } 
        }
        System.out.println(cups[0] == 1 ? 1:cups[1] == 1 ? 2:3);
    }
}