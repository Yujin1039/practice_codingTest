import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        int[] arrNum = new int[1000];
        for(int i:array){
            arrNum[i]++;
        }
        int[] copyNum = Arrays.copyOf(arrNum,arrNum.length);
        Arrays.sort(copyNum);
        
        if(copyNum[999] == copyNum[998]){
            answer = -1;
        }else{
            for(int i=0;i<1000;i++){
                if(arrNum[i] == copyNum[999]){
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }
}