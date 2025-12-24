import java.util.*;
import java.io.*;
import java.util.Collections.*;
import java.math.*;

public class Main {        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        List<BigInteger> list = new ArrayList<>();
        for(int i=0; i<T; i++){
            String[] str = br.readLine().split("[a-z]+");
            for (String num : str) {
                if(!num.isEmpty()){
                    list.add(new BigInteger(num));
                }
            }
        }
        Collections.sort(list);
        for (BigInteger num : list) {
            sb.append(num+"\n");
        }
        System.out.println(sb.toString());
    }
}