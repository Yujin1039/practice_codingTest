import java.io.*;
import java.util.*;

public class Main {
    static List<String[]> parrots;
    static List<Integer> curIdx;
    static String[] sentence;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parrots = new ArrayList<>();
        curIdx = new ArrayList<>();
        
        for(int i=0; i<n;i++){   
            parrots.add(br.readLine().split(" "));
            curIdx.add(0);
        }
        
        sentence = br.readLine().split(" ");
        
        System.out.println(isPossible());
    }

    public static String isPossible(){
        for (int i=0; i<sentence.length; i++) {
            String cur = sentence[i];
            boolean flag = true;

            for(int j=0; j<parrots.size(); j++){
                String[] parrot = parrots.get(j);
                int idx = curIdx.get(j);
                if(parrot.length != idx && parrot[idx].equals(cur)){
                    curIdx.set(j, idx+1);
                    flag = false;
                    break;
                }
            }
            
            if(flag) return "Impossible";
        }

        for(int i=0; i<parrots.size(); i++){
            if(parrots.get(i).length != curIdx.get(i)) return "Impossible";
        }
        return "Possible";
    }
}