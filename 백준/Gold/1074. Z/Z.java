import java.util.*;
import java.io.*;

public class Main {
    public static int square(int x,int y,int n,int max){
        if(n == 1){
            if(x == 0 && y == 0){
                return max-4;
            }else if(x == 0 && y == 1){
                return max-3;
            }else if(x == 1 && y == 0){
                return max-2;
            }else{
                return max-1;
            }
        }
        
        int standard = 1<<(n-1);
        int nextMax = (int) Math.pow(4,n-1);
        if(x < standard && y < standard){
            return square(x,y,n-1,max-nextMax*3);
        }else if(x >= standard && y >= standard){
            return square(x-standard,y-standard,n-1,max);
        }else if(x < standard && y >= standard){
            return square(x,y-standard,n-1,max-nextMax*2);
        }else{
            return square(x-standard,y,n-1,max-nextMax);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        System.out.println(square(c,r,N,(int) Math.pow(4,N)));
    }
}