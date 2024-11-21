import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] tmp; 

    static void merge(int st, int en){     
        int mid = (st+en)/2;
        int tM = mid; int tS = st;
        for(int i=st;i<en;i++){
            if(tM == en) tmp[i] = arr[tS++];
            else if(tS == mid) tmp[i] = arr[tM++];
            else if(arr[tS] >= arr[tM]) tmp[i] = arr[tM++];
            else tmp[i] = arr[tS++];
        }
        for(int i=st;i<en;i++) arr[i] = tmp[i];
    }

    static void merge_sort(int st, int en){
        if(st+1 == en) return;
        int mid = (st+en)/2;
        merge_sort(st, mid);
        merge_sort(mid, en);
        merge(st, en);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        tmp = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        merge_sort(0, n);
        System.out.println(Arrays.toString(arr).replace("[","").replace("]","").replace(", ","\n"));
    }
}