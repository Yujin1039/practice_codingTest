import java.io.*;
import java.util.*;

public class Main {   
    static int k;
    static int[] s;
    static int[] tmp = new int[6];
    static StringBuilder sb = new StringBuilder();

    static void lotto(int sIdx, int tIdx){
        if(tIdx == 6){
            for(int t:tmp){
                sb.append(t).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=sIdx;i<k;i++){
            tmp[tIdx] = s[i];
            lotto(i+1,tIdx+1);
        }
    }
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do{
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            s = new int[k];
            for(int i=0;i<k;i++){
                s[i] = Integer.parseInt(st.nextToken());               
            }
            lotto(0,0);
            sb.append("\n");
        }while(k != 0);
        System.out.println(sb);
	}
}