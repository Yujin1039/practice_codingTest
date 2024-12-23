import java.io.*;
import java.util.*;

public class Main { 
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            int m = Integer.parseInt(br.readLine()); // 의상 수
            Map<String,Integer> outfits = new HashMap<>();
            for(int j=0;j<m;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String key = st.nextToken();
                if(outfits.containsKey(key)) outfits.replace(key,outfits.get(key)+1);
                else outfits.put(key,1);
            }
            String[] keysArray = outfits.keySet().toArray(new String[0]);
            int sum = 0;
            int sub = 1;
            for(int j=0;j<keysArray.length;j++){
                sub *= outfits.get(keysArray[j])+1;
            }
            sum += sub;
            sb.append(sum-1).append("\n");
        }        
        System.out.println(sb);
	}
}