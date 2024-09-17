import java.io.*;
import java.util.*;

public class Main {	
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String[] vertex1 = br.readLine().split(" ");
        String[] vertex2= br.readLine().split(" ");
        String[] vertex3= br.readLine().split(" ");
        
        for(int i=0;i<2;i++){
            if(Integer.parseInt(vertex1[i]) == Integer.parseInt(vertex2[i])){
                sb.append(vertex3[i]).append(" ");
            }else if(Integer.parseInt(vertex1[i]) == Integer.parseInt(vertex3[i])){
                sb.append(vertex2[i]).append(" ");
            }else{
                sb.append(vertex1[i]).append(" ");
            }
        }
        System.out.println(sb);
    }
}