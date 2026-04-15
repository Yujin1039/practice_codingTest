import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String next = br.readLine();

        while(!next.equals("0 0")){
            StringTokenizer st = new StringTokenizer(next);
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if(first % second == 0){
                sb.append("multiple").append("\n");
            }else if(second % first == 0){
                sb.append("factor").append("\n");
            }else{
                sb.append("neither").append("\n");
            }            
            next = br.readLine();
        }        
		System.out.println(sb);		
	}
}