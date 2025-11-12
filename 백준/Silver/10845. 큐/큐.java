import java.io.*;
import java.util.*;

public class Main { 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());   
        Deque<Integer> q =new ArrayDeque<>();
		for(;a>0;a--){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            String command = st.nextToken();
            if(command.equals("push")){
                int b = Integer.parseInt(st.nextToken());
                q.offerLast(b);
            }else if(command.equals("pop")){                
                sb.append(q.isEmpty() ? -1 : q.pollFirst()).append("\n");
            }else if(command.equals("size")){
                sb.append(q.size()).append("\n");
            }else if(command.equals("empty")){
                sb.append(q.isEmpty() ? 1 : 0).append("\n");
            }else if(command.equals("front")){
                sb.append(q.isEmpty() ? -1 : q.peekFirst()).append("\n");
            }else{
                sb.append(q.isEmpty() ? -1 : q.peekLast()).append("\n");
            }
        }
        System.out.println(sb.toString());
	}   
}