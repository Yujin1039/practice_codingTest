import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 주차 공간
        int M = Integer.parseInt(st.nextToken()); // 차량수
        
        int[] parkingLot = new int[N+1];
        int[] car = new int[M+1];       

        // 공간별 요금 저장
        for(int i=1; i<N+1; i++){
            parkingLot[i] = Integer.parseInt(br.readLine());
        }

        // 차량 무게 저장
        for(int i=1; i<M+1; i++){
            car[i] = Integer.parseInt(br.readLine());
        }
        
        // 주차 요금 계산
        long price = 0; 
        ArrayDeque<Integer> waitingList = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=1; i<N+1; i++) {
            pq.add(i);
        }

        LinkedList<int[]> list = new LinkedList<>();
        for (int i=0; i<M*2; i++) {
            int move = Integer.parseInt(br.readLine());
            if(move > 0){
                if(pq.size() > 0){
                    list.add(new int[]{move, pq.poll()});
                } else {
                    waitingList.add(move);
                }
            } else {
                for (int[] c : list) {
                    if(c[0] == Math.abs(move)){
                        pq.add(c[1]);
                        price += parkingLot[c[1]] * car[c[0]];
                        break;
                    }
                }
                if(!waitingList.isEmpty()){
                    list.add(new int[]{waitingList.poll(), pq.poll()});
                }
            }
        }
        System.out.println(price);             
    }
}