import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
               
        StringTokenizer st = new StringTokenizer(br.readLine());     
        int[] arr = new int[n];
        int[] nge = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());                
        }
        
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();                    
            }
            nge[i] = stack.isEmpty() ? -1:stack.peek();
            stack.push(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int m:nge){
            sb.append(m+" ");
        }
        System.out.println(sb);
    }
}