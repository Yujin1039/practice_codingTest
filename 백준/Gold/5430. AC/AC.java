import java.util.*;
import java.io.*;

public class Main { 
    static String ac(String str,LinkedList<Integer> list){
        boolean isReversed = false;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c == 'R'){
                isReversed = !isReversed;
            }else if(list.size() == 0){
                return "error";
            }else if(isReversed){
                list.removeLast();
            }else{
                list.removeFirst();
            }
        }
        if(isReversed) Collections.reverse(list);
        return list.toString().replace(", ",",");
    } 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<test;i++){
            String str = br.readLine();
            int len = Integer.parseInt(br.readLine());
            LinkedList<Integer> list = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine(),"[,]");
            for(int j=0;j<len;j++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            sb.append(ac(str,list)).append("\n");
        }
        System.out.println(sb);
    }
}