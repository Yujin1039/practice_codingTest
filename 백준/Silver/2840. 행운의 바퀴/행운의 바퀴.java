import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        char[] wheel = new char[N];
        int idx = 0;
        boolean flag = false;
        List<Character> list = new LinkedList<>();
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            idx = (idx+Integer.parseInt(st.nextToken())) % N;
            char arrow = st.nextToken().charAt(0);
            
            if((wheel[idx] == '\u0000' && !list.contains(arrow))|| wheel[idx] == arrow) {
                wheel[idx] = arrow;
                list.add(arrow);
            } else {
                System.out.println("!");
                flag = true;
                break;
            }
        }

        
        StringBuilder ans = new StringBuilder();
        if(!flag){
            for(int i=0; i<N; i++){
                if(wheel[(idx+N)%N] == '\u0000') ans.append("?");
                else ans.append(wheel[(idx+N)%N]);
                idx--;
            }
            System.out.println(ans.toString());
        }
    }
}