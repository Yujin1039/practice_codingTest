import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));               
        StringTokenizer expression = new StringTokenizer(br.readLine(),"\\+|-",true);     

        int result = 0; int tmp = 0; boolean tmpC = false;
        while(expression.hasMoreTokens()){
            String c = expression.nextToken();
            if(!tmpC){
                if(c.charAt(0) == 45) tmpC = true;
                else if(c.charAt(0) != 43) result += Integer.parseInt(c);
            }else if(c.charAt(0) != 43 && c.charAt(0) != 45) tmp += Integer.parseInt(c);                
        }
        if(tmp != 0) result -= tmp;
        System.out.println(result);
    }
}