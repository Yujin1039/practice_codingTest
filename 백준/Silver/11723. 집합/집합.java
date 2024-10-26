import java.util.*;
import java.io.*;

public class Main {
    static int[] set = new int[20];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String method = st.nextToken();

            if(method.equals("add")){
                int x = Integer.parseInt(st.nextToken());
                set[x-1] = x;
            }else if(method.equals("remove")){
                int x = Integer.parseInt(st.nextToken());
                set[x-1] = 0;
            }else if(method.equals("check")){
                int x = Integer.parseInt(st.nextToken());
                sb.append(set[x-1] == x ? 1:0).append("\n");
            }else if(method.equals("toggle")){
                int x = Integer.parseInt(st.nextToken());
                if(set[x-1] == x) set[x-1] = 0;
                else set[x-1] = x;
            }else if(method.equals("empty")){
                for(int j=0;j<20;j++){
                    set[j] = 0;
                }
            }else{
                for(int j=0;j<20;j++){
                    set[j] = j+1;
                }
            }
        }
        System.out.println(sb.toString());
    }
}