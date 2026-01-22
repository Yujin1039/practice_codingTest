import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    

        int N = Integer.parseInt(br.readLine());
        Map<String,Integer> map = new TreeMap<>();
        
        for(int i=0; i<N; i++){
            String title = br.readLine();
            if(map.containsKey(title)) map.put(title, map.get(title)+1);
            else map.put(title,1);
        }
        
        String key = ""; int max = 0;
        for(String title:map.keySet()){
            if(map.get(title) > max){
                max = map.get(title);
                key = title;
            }
        }
        System.out.println(key);
    }
}