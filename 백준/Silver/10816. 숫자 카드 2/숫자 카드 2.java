import java.io.*;
import java.util.*;

public class Main { 
    static int[] createArray(int n,String cardNum){
        int i=0;
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(cardNum);
        while(st.hasMoreTokens()){
            arr[i++] = Integer.parseInt(st.nextToken());
        }        
        return arr;
    }
    static int lowerBound(int[] arr, int m) {
        int pl = 0;
        int pr = arr.length-1;
        
        while (pl <= pr) {
            int mid = (pl + pr) / 2;
            if (arr[mid] >= m) {
                pr = mid -1;
            } else {
                pl = mid + 1;
            }
        }
        return pl;
    }
    static int upperBound(int[] arr, int m) {
        int pl = 0;
        int pr = arr.length-1;
        
        while (pl <= pr) {
            int mid = (pl + pr) / 2;
            if (arr[mid] > m) {
                pr = mid -1;
            } else {
                pl = mid + 1;
            }
        }
        return pl;
    }

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));  
        
        int a = Integer.parseInt(br.readLine());
        int[] myCard = createArray(a,br.readLine());
        Arrays.sort(myCard);
        
        int b = Integer.parseInt(br.readLine());
        int[] card = createArray(b,br.readLine());
        
        for(int i=0;i<b;i++){
            int cNum = card[i]; 
            int lower = lowerBound(myCard,cNum);
            int upper = upperBound(myCard,cNum);
            card[i] = upper - lower;
        }        
        System.out.println(Arrays.toString(card).replace("[","").replace("]","").replace(",",""));
	}    
}