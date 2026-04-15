import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String function = br.readLine();
        String[] terms = function.split("x\\+|x");

        if(function.contains("x")){
            int cof = Integer.parseInt(terms[0])/2;
            terms[0] = (cof == 1) ? "xx":(cof == -1) ? "-xx":cof+"xx";

            if(terms.length == 2){
                int cof2 = Integer.parseInt(terms[1]);
                if(cof2 == 1){
                    terms[1] = "+x";
                } else if(cof2 == -1){
                    terms[1] = "-x";
                } else if(cof2 > 1){
                    terms[1] = "+"+terms[1]+"x";
                } else if(cof2 < 1){
                    terms[1] = terms[1]+"x";
                }
                System.out.println(terms[0]+""+terms[1]+"+W");
            } else {
                System.out.println(terms[0]+"+W");
            }
                        
        } else if(!terms[0].equals("0")){
            terms[0] = (terms[0].equals("1")) ? "":(terms[0].equals("-1")) ? "-":terms[0];  
            System.out.println(terms[0]+"x+W");  
        } else {
            System.out.println("W");  
        }              
    }
}