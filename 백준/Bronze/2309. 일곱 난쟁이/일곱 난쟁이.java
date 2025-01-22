import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] list = new int[9];

        int sum = -100;
        for(int i=0;i<9;i++){
            int height = Integer.parseInt(br.readLine());
            sum += height;
            list[i] = height;
        }
        Arrays.sort(list);

        for(int i=0;i<9;i++){
            for(int j=i+1;j<9;j++){
                if(sum == list[i] + list[j]){
                    StringBuilder sb = new StringBuilder();
                    for(int num:list){
                        if(num != list[i] && num != list[j]){
                            sb.append(num).append("\n");
                        }
                    }
                    System.out.println(sb);
                    return;
                }                 
            }
        }
    } 
}