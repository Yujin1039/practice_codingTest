import java.util.*;
import java.io.*;

public class Main {        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int end = 21;
        int point = 0;
        int turn = 0;
        int cur = 0;
        boolean isSuccess = true;
        
        for(int i=0; i<50; i++){
            String rst = br.readLine();
            int move = 0;
            for(int j=0; j<4; j++){
                if(rst.charAt(j) == '0') move++;
            }

            if(move == 0){
                cur += 5;
            } else {
                cur += move;
            }

            if(point == 0 && (cur == 5 || cur == 10)){
                end = 17;
                point++;
            } else if(point == 1 && cur == 8) {
                end = 12;
                point++;
            } 

            if(move != 4 && move != 0) turn++;

            if(cur >= end && turn <= 10){
                break;
            } else if(turn == 10){
                isSuccess = false;
                break;
            }
        }

        System.out.println(isSuccess ? "WIN":"LOSE");        
    }
}