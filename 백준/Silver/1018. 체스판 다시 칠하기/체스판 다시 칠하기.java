import java.io.*;
import java.util.*;

public class Main { 
    static int countSquare(String[] arr,int l,int w){           
        int square = 0;
        char std = 'W';     
        
        for(int i=l;i<l+8;i++){
            int k = 0;
            for(int j=w;j<w+8;j++){                
                if(arr[i].charAt(j) != std) square++; 
                std = std == 'W' ? 'B':'W';
            } 
            std = std == 'W' ? 'B':'W';
        }  
        int square2 = 64-square;
        return square > square2 ? square2:square;        
    }
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] chessBoard = new String[n];
        for(int i=0;i<n;i++){            
            chessBoard[i] = br.readLine();
        }
        
        int min = 0;
        for(int l=0;l+8<=n;l++){
            for(int w=0;w+8<=m;w++){
                int count = countSquare(chessBoard,l,w);
                if(l == 0 && w == 0) {
                    min = count;  
                }else if(count < min){
                    min = count;
                }    
            }
        }
        
        System.out.println(min);
	}    
}