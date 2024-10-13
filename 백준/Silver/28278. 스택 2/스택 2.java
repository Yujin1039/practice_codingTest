import java.util.*;
import java.io.*;


    
public class Main {
    public static Deque<Integer> stack = new ArrayDeque<>();

    public static Integer stackMethod(int a){
        if(a == 2){
            Integer b = stack.pollLast();
            return b == null ? -1:b;
        }else if(a == 3){
            return stack.size();
        }else if(a == 4){
            return stack.isEmpty() ? 1:0;
        }else{
            Integer c = stack.peekLast();
            return c == null ? -1:c;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int mth = Integer.parseInt(st.nextToken());
            if(mth == 1){
                int num = Integer.parseInt(st.nextToken());
                stack.offer(num);
            }else{
                sb.append(stackMethod(mth)).append("\n");
            }
        }
        System.out.println(sb);
    }
}