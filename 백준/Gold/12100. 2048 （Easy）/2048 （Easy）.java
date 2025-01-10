import java.util.*;
import java.io.*;

public class Main { 
    static int n;
    static int[][] box;
    static int[][] tmp;
    static int result = 0;
    static void moveBox(int[][] cur,int pre,int cnt){
        if(cnt == 5){
            for(int[] c:cur){
                for(int num:c){
                    if(num > result) result = num;
                }
            }
            return;
        }
        for(int i=0;i<4;i++){
            for (int row = 0; row < n; row++) {
                tmp[row] = Arrays.copyOf(cur[row], n);
            }
            int[][] arr = move(tmp,i); 
            moveBox(arr,i,cnt+1);                       
        }
    }

    static int[][] move(int[][] prev,int dir){
        int[][] cur = new int[n][n];
        if(dir == 0){
            for(int i=0;i<n;i++){
                int k = n-1;
                for(int j=n-1;j>=0;j--){
                    if(prev[i][j] != 0){
                        for(int l=j-1;l>=0;l--){
                            if(prev[i][j] == prev[i][l]){
                                cur[i][k--] = prev[i][j] + prev[i][l];
                                prev[i][l] = 0;
                                break;
                            }else if(prev[i][l] != 0) {
                                cur[i][k--] = prev[i][j];
                                prev[i][j] = 0;
                                break;
                            }else if(l == 0){
                                cur[i][k--] = prev[i][j];
                            }
                        }
                        if(j == 0) cur[i][k--] = prev[i][j];
                    }
                } 
            }
        }else if(dir == 1){
            for(int j=0;j<n;j++){
                int k = n-1;
                for(int i=n-1;i>=0;i--){
                    if(prev[i][j] != 0){
                        for(int l=i-1;l>=0;l--){
                            if(prev[i][j] == prev[l][j]){
                                cur[k--][j] = prev[i][j] + prev[l][j];
                                prev[l][j] = 0;
                                break;
                            }else if(prev[l][j] != 0) {
                                cur[k--][j] = prev[i][j];
                                prev[i][j] = 0;
                                break;
                            }else if(l == 0){
                                cur[k--][j] = prev[i][j];
                            }
                        }                        
                        if(i == 0) cur[k--][j] = prev[i][j];
                    }
                }
            }
        }else if(dir == 2){
            for(int i=0;i<n;i++){
                int k = 0;
                for(int j=0;j<n;j++){
                    if(prev[i][j] != 0){
                        for(int l=j+1;l<n;l++){
                            if(prev[i][j] == prev[i][l]){
                                cur[i][k++] = prev[i][j] + prev[i][l];
                                prev[i][l] = 0;
                                break;
                            }else if(prev[i][l] != 0) {
                                cur[i][k++] = prev[i][j];
                                prev[i][j] = 0;
                                break;
                            }else if(l == n-1){
                                cur[i][k++] = prev[i][j];
                            }
                        }
                        if(j == n-1) cur[i][k++] = prev[i][j];
                    }
                }
            }
        }else{
            for(int j=0;j<n;j++){
                int k = 0;
                for(int i=0;i<n;i++){
                    if(prev[i][j] != 0){
                        for(int l=i+1;l<n;l++){
                            if(prev[i][j] == prev[l][j]){
                                cur[k++][j] = prev[i][j] + prev[l][j];
                                prev[l][j] = 0;
                                break;
                            }else if(prev[l][j] != 0) {
                                cur[k++][j] = prev[i][j];
                                prev[i][j] = 0;
                                break;
                            }else if(l == n-1){
                                cur[k++][j] = prev[i][j];
                            }
                        } 
                        if(i == n-1) cur[k++][j] = prev[i][j];
                    }
                }
            }
        }  
        return cur;
    }
       
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        n = Integer.parseInt(br.readLine());
        box = new int[n][n];
        tmp = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        moveBox(box,-1,0);
        System.out.println(result);
    }
}