import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<int[]> list = new ArrayList<>();
        int prev = -1;
        for(int i=0; i<N; i++){
            int cur = Integer.parseInt(st.nextToken());
            if (i>0 && cur % 2 == prev % 2){
                list.get(list.size()-1)[1]++;
            } else {
                list.add(new int[]{(cur+2) % 2, 1});
                prev = cur % 2;
            }
        }

        // 왼쪽 기준 홀수 정렬
        int oddS = 1;
        int curMove = 0;
        long moveOdd = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i)[0] != oddS) curMove += list.get(i)[1];
            else moveOdd += (long) curMove*list.get(i)[1];
        }

        // 왼쪽 기준 짝수 정렬
        int evenS = 0;
        curMove = 0;
        long moveEven = 0;
        for(int i=0; i<list.size(); i++){
            if(list.get(i)[0] != evenS) curMove += list.get(i)[1];
            else moveEven += (long) curMove*list.get(i)[1];
        }
 
        System.out.println(Math.min(moveOdd, moveEven));
    }
}