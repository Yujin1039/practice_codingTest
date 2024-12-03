import java.io.*;
import java.util.*;

public class Main { 
    private static LinkedHashSet<String> total;
    private static int n;
    private static int m;
    private static int[] num;
    private static int[] tmp;
    private static boolean[] isChecked;
    //                  (tmp 시작점)
    static void alignNum(int start){
        if(start == m){
            StringBuilder sb = new StringBuilder();
            for(int a:tmp){
                sb.append(a).append(" ");
            }
            sb.append("\n");
            if(!total.contains(sb.toString())) total.add(sb.toString());
            return;
        }
        
        for(int i=0;i<n;i++){
            if(!isChecked[i]){
                tmp[start] = num[i];
                isChecked[i] = true;
                alignNum(start+1);
                isChecked[i] = false;
            }
            
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        total = new LinkedHashSet<>();
        num = new int[n];
        tmp = new int[m];
        isChecked = new boolean[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        
        alignNum(0);

        Iterator<String> list = total.iterator();
        StringBuilder sb = new StringBuilder();
        while(list.hasNext()){
            sb.append(list.next());
        }
        System.out.println(sb);
    }    
}