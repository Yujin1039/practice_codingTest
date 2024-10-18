import java.util.*;
import java.io.*;
   
public class Main {     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push")){
                queue.add(Integer.parseInt(st.nextToken()));
            }else if(cmd.equals("pop")){
                int pop = queue.isEmpty() ? -1:queue.poll();
                sb.append(pop).append("\n");
            }else if(cmd.equals("size")){
                sb.append(queue.size()).append("\n");
            }else if(cmd.equals("front")){
                sb.append(queue.isEmpty() ? -1:queue.peek()).append("\n");
            }else if(cmd.equals("back")){
                sb.append(queue.isEmpty() ? -1:queue.peekLast()).append("\n");
            }else {
                sb.append(queue.isEmpty() ? 1:0).append("\n");
            }            
        }                
        System.out.println(sb.length() > 0 ? sb.deleteCharAt(sb.length()-1).toString():sb.toString());
    }
}