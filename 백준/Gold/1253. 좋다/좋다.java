import java.util.*;
import java.io.*;

public class Main {    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        int GOOD_NUM = 0;
        for(int i=0; i<N; i++){
            int max = (i == N-1) ? N-2:N-1; 
            int min = (i == 0) ? 1:0;

            while(max > min){
                int sum = numbers[max]+numbers[min];
                
                if(sum > numbers[i]){
                    max--;
                } else if(sum < numbers[i]){
                    min++;
                } else if(sum == numbers[i]){
                    if(max != i && min != i) {
                        GOOD_NUM++;
                        break;
                    } else if(max == i) {
                        max--;
                    } else if(min == i) {
                        min++;
                    }
                }
            }
        }
        System.out.println(GOOD_NUM);
    }
}