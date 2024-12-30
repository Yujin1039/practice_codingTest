import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<t;i++){
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer,Integer> map = new TreeMap<>();
            for(int j=0;j<k;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String method = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if(method.equals("I")){
                    if(map.containsKey(num)) map.put(num,map.get(num)+1);
                    else map.put(num,1);                    
                }else if(!map.isEmpty()){
                    if(num == 1){
                        Map.Entry<Integer,Integer> entry = map.lastEntry();
                        if(entry.getValue() == 1) map.pollLastEntry();
                        else map.put(entry.getKey(),map.get(entry.getKey())-1);
                    }else {
                        Map.Entry<Integer,Integer> entry = map.firstEntry();
                        if(entry.getValue() == 1) map.pollFirstEntry();
                        else map.put(entry.getKey(),map.get(entry.getKey())-1);
                    }
                }            
            }
            if(!map.isEmpty()) {
                Map.Entry<Integer,Integer> last = map.lastEntry();
                Map.Entry<Integer,Integer> first = map.firstEntry();
                sb.append(last.getKey()).append(" "+first.getKey()).append("\n");
            }else sb.append("EMPTY").append("\n");
        }
        System.out.println(sb);
    }
}