import java.util.*;

class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        
        int[][] price = new int[n+1][n+1];
        for(int i=0; i<=n; i++){
            Arrays.fill(price[i], Integer.MAX_VALUE);
            price[i][i] = 0;
        }
        
        for(int i=0; i<fares.length; i++){
            int start = fares[i][0];
            int e = fares[i][1];
            int p = fares[i][2];
            
            price[start][e] = p;
            price[e][start] = p;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                for(int k=1; k<=n; k++){                    
                    if(price[j][i]+price[i][k] >= 0){
                        price[j][k] = Math.min(price[j][k], price[j][i]+price[i][k]);
                    }                    
                }
            }
        }
        
        answer = price[s][a]+price[s][b];
        System.out.println(answer);
        for(int i=1; i<=n; i++){
            if(price[s][i] + price[i][a] + price[i][b] > 0){
                answer = Math.min(answer, price[s][i] + price[i][a] + price[i][b]);
            }            
        }
        return answer;
    }
}