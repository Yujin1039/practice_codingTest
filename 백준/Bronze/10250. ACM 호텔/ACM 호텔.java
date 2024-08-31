import java.io.*;
import java.util.*;

public class Main { 
    static String roomNum(int h, int w, int n){
        int floor = (n % h == 0)? h:n % h;
        int room = (n % h == 0)? n / h:n / h + 1;
        String mid = (room < 10)? "0":"";
        return floor + mid + room;
    }
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            sb.append(roomNum(h,w,n)).append("\n");
        }                           
        System.out.println(sb.toString());
	}    
}