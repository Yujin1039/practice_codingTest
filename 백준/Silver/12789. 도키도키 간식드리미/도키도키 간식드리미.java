import java.util.*;
import java.io.*;

public class Main {
    static Deque<Integer> row2 = new ArrayDeque<>();
    
    public static String getSnack(Deque<Integer> row1,int n){
        int i = 1;
        while(i<n){
            if(row1.peek() != null && row1.peek() == i){
                row1.remove();
                i++;
            }else if(row2.peekLast() != null && row2.peekLast() == i){
                row2.removeLast();
                i++;
            }else if(row1.peek() != null && row1.peek() != i){
                row2.add(row1.remove());
            }else{
                return "Sad";
            }
        }
        return "Nice";
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Deque<Integer> row1 = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            row1.add(num);
        }
        System.out.println(getSnack(row1,n));
    }
}