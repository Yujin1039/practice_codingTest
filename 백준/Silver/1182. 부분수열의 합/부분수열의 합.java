import java.util.*;
import java.io.*;

class Main { 
    static int n;
    static int s;
    static int num;
    static int[] seq;
    
    static void subSeq(int cur,int total){
        if(cur == n){            
            if(total == s) num++;            
            return;
        }        
        subSeq(cur+1,total);           //total에 seq[cur]이 포함되지 않았을 때 total == s인지 확인
        subSeq(cur+1,total+seq[cur]);  //total에 seq[cur]이 포함되었을 때 total == s인지 확인
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());        
        seq = new int[n];        

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        subSeq(0,0);
        if(s == 0) num--;
        
        System.out.println(num);
    }
}