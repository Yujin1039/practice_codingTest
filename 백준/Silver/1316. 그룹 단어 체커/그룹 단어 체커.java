import java.util.*;
import java.io.*;

public class Main {      
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  
        int count = N;
        
        while(N > 0){
            String word = br.readLine();
            int[] alphabet = new int[26];
            char prev = 0;
            for(int i=0;i<word.length();i++){
                if(word.charAt(i) != prev){
                    if(++alphabet[word.charAt(i)-97] > 1) {
                        count--;
                        break;
                    }
                    prev = word.charAt(i);
                }
            }
            N--;
        }          
        System.out.println(count);
    }
}