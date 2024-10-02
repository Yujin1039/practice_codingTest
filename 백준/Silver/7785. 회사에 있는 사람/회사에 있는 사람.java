import java.util.*;
import java.io.*;

public class Main {
    public static boolean isNumeric(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch(Exception e){
            return false;
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
    
        Map<String,String> log = new TreeMap<>();
        for(int i = 0; i < n; i++){
    		StringTokenizer st = new StringTokenizer(br.readLine());                
            log.put(st.nextToken(),st.nextToken());
        }

        List<String> enter = new ArrayList<>();
        for(String s:log.keySet()){
            if(log.get(s).equals("enter")){
                enter.add(s);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = enter.size() - 1; i >= 0; i--) {
            sb.append(enter.get(i)).append("\n");
        }

        System.out.println(sb.toString());
	}
}