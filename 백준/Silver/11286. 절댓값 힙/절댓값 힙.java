import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> tree = new PriorityQueue<>(
            (o1,o2)->{
                if(Math.abs(o1)==Math.abs(o2)){
                    return o1-o2;
                }
                return Math.abs(o1)-Math.abs(o2);
            }
        );
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            int m = Integer.parseInt(br.readLine());
            if(m == 0){
                sb.append(tree.peek()!=null ? tree.poll():0).append("\n");
            }else{
                tree.add(m);
            }
        }        
        System.out.println(sb);
	}
}