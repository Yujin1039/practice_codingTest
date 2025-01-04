import java.util.*;
import java.io.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=2;i<=n;i++) list.add(i);
        int k = Integer.parseInt(st.nextToken());
        int cnt = 0;

        while(!list.isEmpty()){
            int start = list.peek();
            for(int j=start;j<=n;j += start){
                if(list.contains((Integer) j)){
                    list.remove((Integer) j);
                    cnt++;
                }
                if(cnt == k){
                    System.out.println(j);
                    return;
                }  
            }
        }
    }
}