import java.util.*;
import java.io.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        String str;
        List<Integer> list = new ArrayList<>();
        
        while(!(str = br.readLine()).equals("0 0 0")){
            StringTokenizer st = new StringTokenizer(str);
            int L = Integer.parseInt(st.nextToken()); // 연속 사용 가능한 캠핑장 일수
            int P = Integer.parseInt(st.nextToken()); // 연속된 일수
            int V = Integer.parseInt(st.nextToken()); // 총 휴가일수

            int rest = V % P < L ? V % P:L;
            list.add(V/P * L+ rest);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++){
            sb.append(String.format("Case %d: %d",i+1,list.get(i))).append("\n");
        }
        System.out.println(sb);
    }
}