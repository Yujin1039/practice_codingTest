import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        
        List<ArrayDeque<Integer>> list = new ArrayList<>();
        for(int i=0; i<=N; i++){
            list.add(new ArrayDeque<Integer>());
        }
        long total = 0;
        
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int prep = Integer.parseInt(st.nextToken());

            while (!list.get(num).isEmpty() && list.get(num).peek() > prep) {
                total++;
                list.get(num).pop();
            } 
            if(!list.get(num).isEmpty() && list.get(num).peek() != prep){
                total++;
                list.get(num).push(prep);
            } else if(list.get(num).isEmpty()){
                total++;
                list.get(num).push(prep);
            }
        }
        System.out.println(total);       
    }
}