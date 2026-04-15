import java.util.*;
import java.io.*;
import java.util.Collections.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        for (int i=0; i<N; i++) {
            String[] file = br.readLine().split("\\.");
            map.put(file[1], map.getOrDefault(file[1], 0)+1);
        }

        Set<String> keys = map.keySet();
        List<String> keyList = new ArrayList<>(keys);
        Collections.sort(keyList);

        StringBuilder sb = new StringBuilder();
        for(String key:keyList){
            sb.append(key+" "+map.get(key));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}