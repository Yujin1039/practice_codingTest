import java.util.*;
import java.io.*;

public class Main {     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());

        int last = (int) Math.sqrt(end);
        boolean[] isPrime = new boolean[last+1];
        ArrayList<Integer> prime = new ArrayList<>();
        isPrime[0] = isPrime[1] = true;
        for(int i=2;i<=last;i++){
            if(!isPrime[i]){
                prime.add(i);
                for(int j=i*2;j<=last;j+=i){
                    isPrime[j] = true;
                }
            }
        }
        long result = 0;
        for(int p:prime){
            long ap = (long) p * p;
            while (ap <= end) {
                if (ap >= start) result++;                
                if (ap > Long.MAX_VALUE / p) break;
                ap *= p;
            }
        }
        System.out.println(result);
    }
}