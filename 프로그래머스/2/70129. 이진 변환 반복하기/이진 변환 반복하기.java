import java.util.*;

class Solution {
    public int[] solution(String s) {
        int exchange = 0;
        int removedZero = 0;
        
        while(!s.equals("1")){
            removedZero += (s.length()-s.replaceAll("0","").length());
            
            int len = s.replaceAll("0","").length();
            s = Integer.toBinaryString(len); 
            exchange++;
        }
        
        int[] answer = new int[2];
        answer[0] = exchange;
        answer[1] = removedZero;
        
        return answer;
    }
}