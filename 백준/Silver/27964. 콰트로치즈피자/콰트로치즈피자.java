import java.util.*;
import java.io.*;

public class Main {    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> cheese = new HashSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            String obj = st.nextToken();
            int len = obj.length();
            if(len > 5 && obj.substring(len-6,len).equals("Cheese")){
                cheese.add(obj);
            }
        }        
        
        System.out.println(cheese.size() >= 4 ? "yummy":"sad");
    }
}