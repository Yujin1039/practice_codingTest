import java.io.*;
import java.util.*;

public class Main {      
    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] space = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            int[] tmp = space[i].clone();
            Arrays.sort(tmp);
            for(int j=0;j<m;j++){
                space[i][j] = binarySearch(tmp,space[i][j]);
            }
        }

        int even = 0;
        for(int i=0;i<n;i++){
            for(int k=i+1;k<n;k++){
                boolean flag = true;
                for(int j=0;j<m;j++){
                    if(space[i][j] != space[k][j]){
                        flag = false;
                        break;
                    } 
                }
                if(flag) even++;                     
            }
        }
        System.out.println(even);
	}
    private static int binarySearch(int[] arr,int target){
        int start = 0; int end = arr.length;
        int mid = 0;
        
        while(start < end){
            mid = (start+end)/2;
            if(arr[mid] >= target){
                end = mid;
            }else{
                start = mid+1;
            }
        }
        return start;
    }
}