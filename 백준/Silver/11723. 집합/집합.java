import java.util.*;
import java.io.*;

public class Main {
    static HashSet<Integer> set;
    static HashSet<Integer> allSet;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        set = new HashSet<>();
        allSet = new HashSet<>();
        for(int i=1;i<=20;i++){
            allSet.add(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String method = st.nextToken();

            if(method.equals("add")){
                set.add(Integer.parseInt(st.nextToken()));
            }else if(method.equals("remove")){
                set.remove(Integer.parseInt(st.nextToken()));
            }else if(method.equals("check")){
                sb.append(set.contains(Integer.parseInt(st.nextToken())) ? 1:0).append("\n");
            }else if(method.equals("toggle")){
                int x = Integer.parseInt(st.nextToken());
                if(!set.add(x)) set.remove(x);
            }else if(method.equals("empty")){
                set.clear();
            }else if(method.equals("all")){
                set = (HashSet) allSet.clone();
            }
        }
        System.out.println(sb.toString());
    }
}