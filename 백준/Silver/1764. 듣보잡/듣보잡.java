import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
    
        Map<String,String> roster = new TreeMap<>();
        for(int i = 0; i < n; i++){                
            roster.put(br.readLine(),"~l");
        }
        
        int lr = 0;
        List<String> list = new LinkedList<>();
        for(int i=0;i<m;i++){
            String name = br.readLine();
            if(roster.get(name) != null){
                lr++;
                list.add(name); 
            }
        }
        
        Collections.sort(list);
        System.out.println(lr);
        System.out.println(list.toString().replace("[","").replace("]","").replace(", ","\n"));
	}
}