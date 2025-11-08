import java.util.*;
import java.io.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] stick = br.readLine().toCharArray();
        int parentheses = 1;
        int pieces = 0;

        for(int i=1;i<stick.length;i++){
            if(stick[i] == ')'){
                parentheses--;
                if(stick[i-1] == '(') pieces += parentheses;
                else pieces++;
            }else{
                parentheses++;
            }
        }
        System.out.println(pieces);
    }
}