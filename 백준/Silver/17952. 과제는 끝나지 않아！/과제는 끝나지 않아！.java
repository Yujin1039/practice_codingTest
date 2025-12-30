import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        ArrayDeque<int[]> taskStack = new ArrayDeque<>();
        int score = 0;
        for(int i=0; i<N; i++){
            String[] task = br.readLine().split(" ");

            if(task.length > 1){
                int sco = Integer.parseInt(task[1]);
                int time = Integer.parseInt(task[2]);
                
                if(time == 1){
                    score += sco;
                } else {
                    taskStack.push(new int[]{sco, time-1});
                }
                
            } else if(!taskStack.isEmpty()){
                int[] curTask = taskStack.pop();
                curTask[1]--;
                
                if(curTask[1] == 0){
                    score += curTask[0];
                } else {
                    taskStack.push(curTask);
                }
            }
        }
        System.out.println(score);       
    }
}