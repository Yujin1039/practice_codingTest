import java.util.*;
import java.io.*;


    
public class Main {     

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] queue = new int[2*n+1];
        int head = n; int tail = n;
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if(cmd.equals("push_front")){
                queue[--head] = Integer.parseInt(st.nextToken());
            }else if(cmd.equals("pop_front")){
                int pop = -1;
                if(head != tail){
                    pop = queue[head];
                    queue[head++] = 0;
                }
                sb.append(pop).append("\n");
            }else if(cmd.equals("size")){
                sb.append(tail - head).append("\n");
            }else if(cmd.equals("front")){
                sb.append(head == tail ? -1:queue[head]).append("\n");
            }else if(cmd.equals("back")){
                sb.append(head == tail ? -1:queue[tail-1]).append("\n");
            }else if(cmd.equals("push_back")){
                queue[tail++] = Integer.parseInt(st.nextToken());
            }else if(cmd.equals("pop_back")){
                int pop = -1;
                if(head != tail){
                    pop = queue[tail-1];
                    queue[--tail] = 0;
                }
                sb.append(pop).append("\n");
            }else {
                sb.append(head == tail ? 1:0).append("\n");
            }
        }        
        System.out.println(sb.length() > 0 ? sb.deleteCharAt(sb.length()-1).toString():sb.toString());
    }
}