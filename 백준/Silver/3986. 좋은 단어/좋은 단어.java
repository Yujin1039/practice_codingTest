import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int goodWords = 0;

        for(int i=0;i<n;i++){
            ArrayDeque<Character> stack = new ArrayDeque<>();
            String word = br.readLine();
            for(int j=0;j<word.length();j++){
                char w = word.charAt(j);
                if(stack.isEmpty() || stack.peekLast() != w) stack.add(w);
                else if(stack.peekLast() == w) stack.pollLast();
            }
            if(stack.isEmpty()) goodWords++;
        }
        System.out.println(goodWords);
    }
}