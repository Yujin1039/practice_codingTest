import java.io.*;
import java.util.*;

public class Main {
    static List<Queue<String>> parrots;
    static Queue<String> sentence;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        parrots = new ArrayList<>();
        StringTokenizer st;
        
        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());   
            parrots.add(mkQueue(st));
        }
        
        sentence = mkQueue(new StringTokenizer(br.readLine()));
        
        System.out.println(isPossible());
    }

    public static Queue<String> mkQueue(StringTokenizer st){
        Queue<String> queue = new ArrayDeque<>();
        
        while(st.hasMoreTokens()){
            queue.offer(st.nextToken());
        }
        return queue;
    }

    public static String isPossible(){
        while (!sentence.isEmpty()) {
            String cur = sentence.peek();

            for(int i=0; i<parrots.size(); i++){
                Queue<String> parrot = parrots.get(i);
                if(!parrot.isEmpty() && parrot.peek().equals(cur)){
                    parrot.poll();
                    sentence.poll();
                    break;
                }
            }
            if(!sentence.isEmpty() && sentence.peek().equals(cur)) return "Impossible";
        }

        if(!sentence.isEmpty()) return "Impossible";

        for(int i=0; i<parrots.size(); i++){
            if(parrots.get(i).size() != 0) return "Impossible";
        }
        return "Possible";
    }
}