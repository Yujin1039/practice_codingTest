import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int M;
    static int[] tmp;
    static ArrayList<Integer> list;

    static void getSeq(int nIdx, int tIdx){
        if(tIdx == M){            
            for(int t:tmp){
                sb.append(t).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        for(int i=nIdx;i<list.size();i++){
            tmp[tIdx] = list.get(i);
            getSeq(i,tIdx+1);
        }
    }    
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken());
        int[] num = new int[N];
        tmp = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        list = new ArrayList<>();
        list.add(num[0]);
        for(int i=1;i<N;i++){
            if(num[i] != num[i-1]) list.add(num[i]);
        }
        
        getSeq(0,0);

        System.out.println(sb);
	}
}