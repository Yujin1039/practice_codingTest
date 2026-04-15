import java.util.*;
import java.io.*;

public class Main {
    static long[] tmp;
    static long[] tree;
    
    static long makeSegmentTree(int idx, int start, int end){ 
        if(start == end){
            tree[idx] = tmp[start];
            return tree[idx];
        }

        int mid = (start+end)/2;
        tree[idx] = makeSegmentTree(2*idx, start, mid) + makeSegmentTree(2*idx+1, mid+1, end);
        return tree[idx];
    }

    static void changeValue(int b, long c, int start, int end, int node){
        if(b < start || b > end) return;
        
        tree[node] += c-tmp[b];

        if(start == end) tmp[b] = c;
        else {
            int mid = (start+end)/2;
            changeValue(b, c, start, mid, 2*node);
            changeValue(b, c, mid+1, end, 2*node+1);
        }       
    }

    static long getSum(int b, int c, int start, int end, int node){
        if(start > c || end < b){
            return 0;
        } else if(start >= b && end <= c){
            return tree[node];
        }
        
        int mid = (start+end)/2;
        return getSum(b, c, start, mid, 2*node) + getSum(b, c, mid+1, end, 2*node+1);        
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        tmp = new long[N];       
        for(int i=0; i<N; i++){
            tmp[i] = Long.parseLong(br.readLine());
        }

        tree = new long[4*N];
        makeSegmentTree(1, 0, N-1);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M+K; i++){
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(cmd.equals("1")){
                changeValue(b-1, c, 0, N-1, 1);
            } else {
                sb.append(getSum(b-1, (int)c-1, 0, N-1, 1)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}