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
                
        int[] parking = new int[N+1]; // 주차공간
        ArrayDeque<Integer> waitingList = new ArrayDeque<>(); // 대기 공간
        
        // 주차 요금 계산
        long price = 0; 
        for (int i=0; i<M*2; i++) {
            int move = Integer.parseInt(br.readLine());
            if(move > 0){
                boolean isFull = true;
                for (int j=1; j<=N; j++) {
                    if(parking[j] == 0) {
                        parking[j] = move;
                        price += car[move] * parkingLot[j];
                        isFull = false;
                        break;
                    }
                }
                if(isFull) waitingList.offer(move);
            } else {
                for (int j=1; j<=N; j++) {
                    if(parking[j] == -move) {
                        parking[j] = 0;
                        if(!waitingList.isEmpty()){
                            int wCar = waitingList.poll();
                            parking[j] = wCar;
                            price += car[wCar] * parkingLot[j];
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(price);             
    }
}