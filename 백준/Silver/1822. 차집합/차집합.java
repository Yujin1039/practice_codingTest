import java.util.*;
import java.io.*;
import java.util.Collections.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));    

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        Set<Integer> A = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            A.add(Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            int num = Integer.parseInt(st.nextToken());
            if(A.contains(num)) A.remove(num);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(A.size()+"\n");
        List<Integer> list = new ArrayList<>(A);
        Collections.sort(list);
        for(int num:list){
            sb.append(num+" ");
        }
        System.out.println(sb.toString());
    }
}