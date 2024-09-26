import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split("");
        Arrays.sort(num);
        Collections.reverse(Arrays.asList(num));
        System.out.println(Arrays.toString(num).replace(", ","").replace("]","").replace("[",""));
	}
}