import java.util.*;
import java.io.*;
import java.util.Collections.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    

        double n = 0;
        Map<String,Integer> map = new HashMap<>();
        String tree;
        
        while((tree = br.readLine()) != null){
            if(map.containsKey(tree)) map.put(tree, map.get(tree)+1);
            else map.put(tree,1);
            n++;
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        
        StringBuilder ans = new StringBuilder();
        for(String name:list){
            ans.append(name+" ");
            ans.append(String.format("%.4f",map.get(name)/n*100)+"\n");
        }
        System.out.println(ans);
    }
}