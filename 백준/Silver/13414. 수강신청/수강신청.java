import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 수강가능 인원
        int m = Integer.parseInt(st.nextToken()); // 신청 인원

        Set<String> waitingList = new LinkedHashSet<>();
        for(int i=0;i<m;i++){
            String studentNum = br.readLine();
            if(!waitingList.add(studentNum)){
                waitingList.remove(studentNum);
                waitingList.add(studentNum);
            } 
        }

        Iterator<String> iter = waitingList.iterator();
        StringBuilder sb = new StringBuilder();
        int point = Math.min(n,waitingList.size());
        for(int i=0;i<point;i++){
            sb.append(iter.next()).append("\n");
        }
        System.out.println(sb);
	}
}