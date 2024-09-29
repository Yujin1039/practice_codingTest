import java.util.*;
import java.io.*;

public class Main {
    static int[] tmp;
    static int[] tmp2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
                
        int n = Integer.parseInt(br.readLine());
        Map<Integer,Integer> myCard = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            myCard.put(Integer.parseInt(st.nextToken()),1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<m; i++){
            int card = Integer.parseInt(st.nextToken());
            if(myCard.get(card) == null){
                sb.append(0);
            }else{
                sb.append(myCard.get(card));                
            }
            sb.append(" ");
        }

        System.out.println(sb.toString());
	}
}