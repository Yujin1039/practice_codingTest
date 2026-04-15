import java.util.*;
import java.io.*;

public class Main {   
    static String isMagicSquare(int[][] square, int n){
        // 합
        int sum = n * (n*n + 1) / 2;
        
        // 행, 열의 값 확인
        for(int i=0; i<n; i++){
            int rSum = 0;
            int cSum = 0;
            for(int j=0; j<n; j++){
                rSum += square[i][j];
                cSum += square[j][i];
            }
            if(rSum != sum || cSum != sum) return "FALSE";
        }

        // 대각선 값 확인
        int lSum = 0; int rSum = 0;
        for(int i=0; i<n; i++){            
            lSum += square[i][i];
            rSum += square[i][n-1-i];            
        }
        if(lSum != sum || rSum != sum) return "FALSE";

        return "TRUE";
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] square = new int[n][n];
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                square[i][j] = Integer.parseInt(st.nextToken());
                set.add(square[i][j]);
            }
        }

        if(set.size() != n*n){
            System.out.println("FALSE");
        } else {
            System.out.println(isMagicSquare(square, n));           
        }
    }
}