import java.io.*;
import java.util.*;

public class Main { 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        int sugar = Integer.parseInt(br.readLine());
        int five = sugar/5;
        int three = 0;

        if(sugar % 5 == 1){
            five -= 1;
            three = 2;
        }else if(sugar % 5 == 2){
            five -= 2;
            three = 4;
        }else if(sugar % 5 == 3){
            three = 1;
        }else if(sugar % 5 == 4){
            five -= 1;
            three = 3;
        }
        
        System.out.println(five >= 0 ? five+three : "-1");
	}    
}