import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), ",");
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<k; i++){
            List<Integer> tmp = new ArrayList<>(list);
            list.clear();
            
            for(int j=1; j<tmp.size(); j++){
                list.add(tmp.get(j)-tmp.get(j-1));    
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : list) {
            sb.append(num+",");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}