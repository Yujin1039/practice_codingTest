import java.io.*;
import java.util.*;

public class Main {    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());     
        List<Integer> list = new ArrayList<>();
		for(;a>0;a--){
            int b = Integer.parseInt(br.readLine());     
            list.add(b);
        }
        Collections.sort(list);

        for(int c: list){
            sb.append(c).append("\n");
        }

        System.out.println(sb);
	}
}