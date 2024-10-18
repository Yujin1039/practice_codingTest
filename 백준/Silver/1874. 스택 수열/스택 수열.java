import java.util.*;
import java.io.*;

public class Main {     
    public static String isSequence(int[] seq){
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int pre = 0;
        for(int i=0;i<seq.length;i++){
            int num = stack.isEmpty() ? 1:stack.peek();
            if(num == seq[i]){
                int now;
                if(stack.isEmpty()){
                    now = 1;
                    sb.append("+").append("\n");
                }else{
                    now = stack.pop();
                }
                if(now > pre) pre = now;
                sb.append("-").append("\n");
            }else if(num < seq[i]){
                for(int j=pre+1;j<=seq[i];j++){
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
                pre = seq[i];
            }else{
                return "NO";
            }
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] expectedSeq = new int[n];
        
        for(int i=0;i<n;i++){
            expectedSeq[i] = Integer.parseInt(br.readLine());
        }                
        System.out.println(isSequence(expectedSeq));
    }
}