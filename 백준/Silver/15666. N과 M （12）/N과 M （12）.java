import java.io.*;
import java.util.*;

public class Main {
    static LinkedHashSet<String> ls = new LinkedHashSet<>();
    static int N; static int M;
    static int[] num; static int[] tmp;

    static void getSeq(int nIdx, int tIdx){
        if(tIdx == M){
            StringBuilder sb = new StringBuilder();
            for(int t:tmp){
                sb.append(t).append(" ");
            }
            sb.append("\n");
            if(!ls.contains(sb.toString())) ls.add(sb.toString());
            return;
        }
        
        for(int i=nIdx;i<N;i++){
            tmp[tIdx] = num[i];
            getSeq(i,tIdx+1);
        }
    }    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken());
        num = new int[N];
        tmp = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        
        getSeq(0,0);

        Iterator<String> iter = ls.iterator();
        StringBuilder sb = new StringBuilder();
        while(iter.hasNext()){
            sb.append(iter.next());
        }
        System.out.println(sb);
	}
}