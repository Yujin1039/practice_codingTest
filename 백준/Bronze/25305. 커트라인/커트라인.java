import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int prize = Integer.parseInt(st.nextToken());

        List<Integer> list = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(list);        
        System.out.println(list.get(list.size()-prize));
	}
}