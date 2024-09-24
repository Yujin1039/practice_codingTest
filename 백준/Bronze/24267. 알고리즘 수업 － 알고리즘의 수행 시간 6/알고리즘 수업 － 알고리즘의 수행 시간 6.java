import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long a = Long.parseLong(br.readLine());
        long sum = 0;
        
        for(long i=1;i<a-1;i++){
            sum += i*(a-1-i);
        }        
        System.out.println(sum);
        System.out.println(3);
	}
}