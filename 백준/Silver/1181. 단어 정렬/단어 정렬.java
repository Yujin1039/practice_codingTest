import java.io.*;
import java.util.*;

public class Main { 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());   
        
        Set<String> set = new HashSet<>();
		for(;a>0;a--){
            set.add(br.readLine());
        }

        List<String> list = new LinkedList<>(set);
        Collections.sort(list,
            Comparator.comparingInt(String::length)
                      .thenComparing(Comparator.naturalOrder())
        );
        for(String str: list){
            sb.append(str).append("\n");
        }
        System.out.println(sb.toString());
	}   
}