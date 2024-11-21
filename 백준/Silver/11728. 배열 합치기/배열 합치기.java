import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] A = new int[a];
        int[] B = new int[b];
        
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<a;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<b;i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        int[] merge = new int[a+b];
        int pa = 0; int pb = 0;
        for(int i=0;i<(a+b);i++){
            if(pa == a){
                while(pb != b){
                    merge[i++] = B[pb++];
                }
            }else if(pb == b){
                while(pa != a){
                    merge[i++] = A[pa++];
                }
            }else{
                while(pa < a && A[pa] <= B[pb]){
                    merge[i++] = A[pa++];
                }
                while(pa < a && pb < b && B[pb] < A[pa]){
                    merge[i++] = B[pb++];
                } 
            }                        
            i--;
        } 
        System.out.println(Arrays.toString(merge).replace("[","").replace("]","").replace(",",""));
    }
}