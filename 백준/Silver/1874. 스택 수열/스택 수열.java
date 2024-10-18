import java.util.*;
import java.io.*;

public class Main {     
    public static String isSequence(int[] seq){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int pre = 0;
        for(int i=0;i<seq.length;i++){
            int num = stack.isEmpty() ? 1:stack.peekLast();
            if(num == seq[i]){
                if(stack.isEmpty()) sb.append("+\n");
                else stack.pollLast();
                sb.append("-\n");
            }else if(num < seq[i]){
                for(int j=pre+1;j<=seq[i];j++){
                    stack.offer(j);
                    sb.append("+\n");
                }
                stack.pollLast();
                sb.append("-\n");
            }else{
                return "NO";
            }
            pre = pre > seq[i] ? pre:seq[i];
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