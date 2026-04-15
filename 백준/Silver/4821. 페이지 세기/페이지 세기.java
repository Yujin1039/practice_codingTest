import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String printDoc = br.readLine();

        while (!printDoc.equals("0")) {
            int page = Integer.parseInt(printDoc);
            boolean[] isPrinted = new boolean[page+1];
            
            String[] printRange = br.readLine().split(",");
            for(String range:printRange){
                StringTokenizer st = new StringTokenizer(range,"-");
                int start = Integer.parseInt(st.nextToken());
                if(st.hasMoreTokens()){
                    int end = Integer.parseInt(st.nextToken());
                    if(start > end || start > page || end < 1) continue;
                    end = Math.min(end,page);
                    for(int i=start; i<=end; i++){
                        isPrinted[i] = true;
                    }
                } else {
                    if(start <= page) isPrinted[start] = true;
                }
            }
            int sum = 0;
            for(boolean printed:isPrinted){
                if(printed) sum++;
            }
            sb.append(sum+"\n");
            printDoc = br.readLine();
        }        
        System.out.println(sb.toString());
    }
}