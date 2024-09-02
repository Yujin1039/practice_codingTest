import java.io.*;
import java.util.*;

public class Main { 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> money = new Stack<>();
        int sum = 0;
        
        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                money.pop();
            }else{
                money.push(num);
            }
        }

        while(!money.isEmpty()){
            sum += money.pop();
        }
        System.out.println(sum);
	}    
}