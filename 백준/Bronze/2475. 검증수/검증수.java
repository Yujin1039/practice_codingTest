import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        Map<String,Integer> dict = Map.of(
            "0", 0,
            "1", 1,
            "2", 4,
            "3", 9,
            "4", 6,
            "5", 5,
            "6", 6,
            "7", 9,
            "8", 4,
            "9", 1
        );
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        while(st.hasMoreTokens()){
            sum += dict.get(st.nextToken());
        }
        
        System.out.println(sum%10);
    }
}