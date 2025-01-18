import java.util.*;
import java.io.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 

        Map<String,List<String>> dict = new HashMap<>();
        for(int i=0;i<n;i++){
            String groupName = br.readLine();
            int memNum = Integer.parseInt(br.readLine());
            List<String> member = new ArrayList<>();
            for(int j=0;j<memNum;j++){
                member.add(br.readLine());
            }
            Collections.sort(member);
            dict.put(groupName,member);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++){
            String question = br.readLine();
            int category = Integer.parseInt(br.readLine());

            if(category == 0){
                List<String> member = dict.get(question);
                for(String mem:member){
                    sb.append(mem).append("\n");
                }
            }else{
                for(String group:dict.keySet()){
                    List<String> member = dict.get(group);
                    if(member.contains(question)) sb.append(group).append("\n");
                }          
            }
        }        
        System.out.println(sb);
    }
}