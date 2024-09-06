import java.util.*;
import java.io.*;

public class Main {      
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());  
        int count = 0;
        
        while(N > 0){
            StringBuilder word = new StringBuilder(br.readLine());
            int[] alphabet = new int[26];
            count++;
            for(int i=0;i<word.length();i++){
                if(i > 0 && word.charAt(i) == word.charAt(i-1)){
                    continue;
                }
                if(++alphabet[word.charAt(i)-97] > 1) {
                    count--;
                    break;
                }
            }
            N--;
        }          
        System.out.println(count);
    }
}