import java.util.*;
import java.io.*;

public class Main { 
    static String ac(String str,int[] list){
        boolean isReversed = false;
        int start = 0; int end = list.length-1;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(c == 'R'){
                isReversed = !isReversed;
            }else if(start > end){
                return "error";
            }else if(isReversed) end--;
            else start++;
        }
        StringBuilder sb = new StringBuilder("[");
        if(isReversed){
            for(int i=end;i>=start;i--){
                sb.append(list[i]).append(",");
                if(i == start) sb.deleteCharAt(sb.length()-1);
            }
        }else{
            for(int i=start;i<=end;i++){
                sb.append(list[i]).append(",");
                if(i == end) sb.deleteCharAt(sb.length()-1);
            }
        }
        return sb.append("]").toString();
    } 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int test = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<test;i++){
            String str = br.readLine();
            int len = Integer.parseInt(br.readLine());
            int[] list = new int[len];
            StringTokenizer st = new StringTokenizer(br.readLine(),"[,]");
            for(int j=0;j<len;j++){
                list[j] = Integer.parseInt(st.nextToken());
            }
            sb.append(ac(str,list)).append("\n");
        }
        System.out.println(sb);
    }
}