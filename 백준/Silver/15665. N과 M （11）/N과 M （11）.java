import java.io.*;
import java.util.*;

public class Main { 
    private static StringBuilder sb = new StringBuilder();
    private static int n;
    private static int m;
    private static Set<Integer> num;
    private static int[] tmp;

    static void alignNum(int start){
        if(start == m){            
            for(int a:tmp){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        Iterator<Integer> iter = num.iterator();
        while(iter.hasNext()){
            tmp[start] = iter.next();
            alignNum(start+1);            
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        num = new HashSet<>();
        tmp = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num.add(Integer.parseInt(st.nextToken()));
        }

        alignNum(0);

        System.out.println(sb);
    }    
}