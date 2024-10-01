import java.util.*;
import java.io.*;

public class Main {
    public static boolean isNumeric(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch(Exception e){
            return false;
        }
    }
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());                
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
    
        Map<String,Integer> ecd = new HashMap<>();
        String[] arrEcd = new String[n+1];
        for(int i = 1; i <= n; i++){
            String pocketmon = br.readLine();
            ecd.put(pocketmon,i);
            arrEcd[i] = pocketmon;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            String s = br.readLine();
            if(isNumeric(s)){
                sb.append(arrEcd[Integer.parseInt(s)]);
            }else{
                sb.append(ecd.get(s));
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
	}
}