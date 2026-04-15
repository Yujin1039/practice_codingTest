import java.util.*;
import java.io.*;

public class Main {    
    static int swap(int a, int b, int[] arr){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
        return 1;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] clone = arr.clone();

        int moveAsc = 0;           
        for(int i=0; i<n; i++){
            boolean isChanged = false;
            for(int j=0; j<n-1-i; j++){
                if(arr[j] > arr[j+1]){
                    moveAsc += swap(j, j+1, arr);
                    isChanged = true;
                }
            }
            if(!isChanged) break;
        }
        
        int moveDesc = 0;
        for(int i=n-1; i>=0; i--){
            boolean isChanged = false;
            for(int j=n-1; j>n-1-i; j--){
                if(clone[j] > clone[j-1]){
                    moveDesc += swap(j, j-1, clone);
                    isChanged = true;
                }
            }
            if(!isChanged) break;
        }
        System.out.println(Math.min(moveAsc, moveDesc+1));
    }
}