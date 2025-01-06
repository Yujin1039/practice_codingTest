import java.util.*;
import java.io.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            int m = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int[] arr = new int[m];
            for(int j=0;j<m;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int pre = 0; 
            ArrayList<Integer> endList = new ArrayList<>();
            for(int j=m-1;j>=0;j--){
                if(arr[j] > pre){
                    pre = arr[j];
                    endList.add(j);
                }
            }
            endList.add(-1);
            long profit = 0;
            for(int j=0;j<endList.size()-1;j++){
                int start = endList.get(j+1);
                int end = endList.get(j);
                if(end-start == 1) continue;
                for(int k=start+1;k<end;k++){
                    profit += arr[end]-arr[k];
                }
            }
            sb.append(profit).append("\n");
        }
        System.out.println(sb);
    }
}