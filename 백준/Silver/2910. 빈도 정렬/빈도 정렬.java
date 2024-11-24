import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        
        LinkedHashMap<Long,Integer> map = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            long cur = Long.parseLong(st.nextToken());
            if(map.containsKey(cur)) map.replace(cur,map.get(cur)+1);
            else map.put(cur,1);
        }

        List<Long> keyList = new LinkedList<>(map.keySet());
        Collections.sort(keyList,(o1,o2)->map.get(o2)-map.get(o1));
        
        StringBuilder sb = new StringBuilder();
        for(long key:keyList){
            for(int i=0;i<map.get(key);i++) sb.append(key).append(" ");
        }
        System.out.println(sb);        
    }
}