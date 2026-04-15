import java.io.*;
import java.util.*;

public class Main { 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        StringBuilder sb = new StringBuilder();
          
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());        
        String mp = a * b * c + "";
        
        int[] arr = new int[10];
        for(int i=0;i<mp.length();i++){
            if(mp.charAt(i) == '0'){
                arr[0]++;
            }else if(mp.charAt(i) == '1'){
                arr[1]++;
            }else if(mp.charAt(i) == '2'){
                arr[2]++;
            }else if(mp.charAt(i) == '3'){
                arr[3]++;
            }else if(mp.charAt(i) == '4'){
                arr[4]++;
            }else if(mp.charAt(i) == '5'){
                arr[5]++;
            }else if(mp.charAt(i) == '6'){
                arr[6]++;
            }else if(mp.charAt(i) == '7'){
                arr[7]++;
            }else if(mp.charAt(i) == '8'){
                arr[8]++;
            }else{
                arr[9]++;
            }
        }

        for(int d:arr){
            sb.append(d+"\n");
        }
        System.out.println(sb.toString());
	}    
}