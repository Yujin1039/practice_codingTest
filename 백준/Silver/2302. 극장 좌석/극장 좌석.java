import java.util.*;
import java.io.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] seat = new int[41];
        seat[1] = 1; seat[2] = 2;
        for(int i=3;i<=40;i++){
            seat[i] = seat[i-1] + seat[i-2];
        }

        int fixed = Integer.parseInt(br.readLine());        
        if(fixed == 0){
            System.out.println(seat[n]);
            return;
        }
        
        int pre = 0;
        int answer = 1;
        for(int i=0;i<fixed;i++){
            int cur = Integer.parseInt(br.readLine());
            if(cur != pre+1) answer *= seat[cur-pre-1];
            pre = cur;
        }
        if(pre != n) answer *= seat[n-pre];
        System.out.println(answer);
    }
}