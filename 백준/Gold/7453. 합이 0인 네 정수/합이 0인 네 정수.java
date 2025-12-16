import java.io.*;
import java.util.*;

public class Main {    
    static int N;
    static int[] addArr(int[] x, int[] y){
        int[] arr = new int[N*N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                arr[i*N+j] = x[i]+y[j];
            }
        }
        return arr;
    }
    static int fIdx(int find,int[] arr){
        int max = N*N-1; int min = 0;
        
        while(min < max){
            int mid = (min+max)/2;

            if(arr[mid] >= find){
                max = mid;
            } else {
                min = mid+1;
            }
        }
        return min;
    }
    static int eIdx(int find,int[] arr){
        int max = N*N-1; int min = 0;
        
        while(min < max){
            int mid = (min+max)/2;

            if(arr[mid] > find){
                max = mid;
            } else {
                min = mid+1;
            }
        }
        return min;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];

        for(int i=0;i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] AB = addArr(A,B);
        int[] CD = addArr(C,D);
        Arrays.sort(AB);
        Arrays.sort(CD);
        
        long cnt = 0;
        
        for (int i=0; i<N*N; i++) {
            int find = AB[i]*(-1);
            
            int f = fIdx(find,CD);
            int e = eIdx(find,CD);
            
            if(CD[f] == find){
                cnt += e-f;
                cnt += (e == N*N-1 && CD[e] == find) ? 1:0;
            }            
        }

        System.out.println(cnt);
    }
}