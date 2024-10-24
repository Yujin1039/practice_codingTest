import java.util.*;
import java.io.*;
    
public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
        int n = Integer.parseInt(br.readLine());
        long building = 0;
        
        int[] bFloor = new int[n];
        for(int i=0;i<n;i++){
            bFloor[i] = Integer.parseInt(br.readLine());
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i=0;i<n;i++){ 
            int floor = bFloor[i];
            while(!stack.isEmpty() && floor >= stack.peekLast()){
                stack.removeLast();
            }
            building += stack.size();
            stack.add(floor);
        }        
        System.out.println(building);
    }
}