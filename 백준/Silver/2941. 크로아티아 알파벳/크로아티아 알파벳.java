import java.util.*;
import java.io.*;

public class Main {    
    static int croatia(String[] cre, int ver){
        int minus = 0;
        if(cre.length > 1){
            minus = cre.length-1;
            for(int i=0;i<cre.length-1;i++){
                int len = cre[i].length();
                if(ver == 1 && len > 1 && cre[i].charAt(len-1) == 'z' && cre[i].charAt(len-2) == 'd'){
                    minus += 1;
                }  
                if(ver == 2 && len > 0 && cre[i].charAt(len-1) != 'l' && cre[i].charAt(len-1) != 'n'){
                    minus -= 1;
                }
                if(ver == 2 && len == 0) minus -= 1;
            }
        }
        return minus;
    }
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine()+" ";                
        String[] cre1 = word.split("[-=]");  
        String[] cre2 = word.split("j");
        int count = word.length() - 1 - croatia(cre1,1) - croatia(cre2,2);
        System.out.println(count);
    }
}