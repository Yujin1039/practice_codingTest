import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int[][] tree;

    static int build(int node, int start, int end, int idx){
        if(start == end){
            return tree[node][idx] = arr[start];
        }
        
        int mid = (start+end)/2;
        // 최솟값 업데이트
        if(idx == 0) tree[node][0] = Math.min(build(node*2, start, mid, 0), build(node*2+1, mid+1, end, 0));
        // 최댓값 업데이트
        else tree[node][1] = Math.max(build(node*2, start, mid, 1), build(node*2+1, mid+1, end, 1));
        
        return tree[node][idx];
    }

    static int findMin(int node, int start, int end, int left, int right){
        if(left > end || right < start){ // 범위를 벗어날 때
            return Integer.MAX_VALUE;
        }

        if(left <= start && right >= end){ // 찾는 값이 트리 범위 내 있을 때 
            return tree[node][0];
        }
        
        int mid = (start+end)/2;
        return Math.min(findMin(node*2, start, mid, left, right), findMin(node*2+1, mid+1, end, left, right));
    }

    static int findMax(int node, int start, int end, int left, int right){
        if(left > end || right < start){
            return 0;
        }

        if(left <= start && right >= end){
            return tree[node][1];
        }
        
        int mid = (start+end)/2;
        return Math.max(findMax(node*2, start, mid, left, right), findMax(node*2+1, mid+1, end, left, right));
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }    

        tree = new int[4*N][2];
        build(1, 0, N-1, 0);
        build(1, 0, N-1, 1);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            int min = findMin(1, 0, N-1, a, b);
            int max = findMax(1, 0, N-1, a, b);

            sb.append(min+" "+max+"\n");
        }
        System.out.println(sb.toString());        
    }
}