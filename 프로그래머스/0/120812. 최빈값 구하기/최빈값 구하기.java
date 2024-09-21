import java.util.*;

class Solution {
    public int solution(int[] array) {
        Integer[] arrNum = new Integer[1000];
        Arrays.fill(arrNum, 0);
        for(Integer i:array){
            arrNum[i]++;
        }
        Integer[] copyNum = Arrays.copyOf(arrNum,arrNum.length);
        Arrays.sort(copyNum);
        List<Integer> list = Arrays.asList(arrNum); 
        return copyNum[999] == copyNum[998] ? -1:list.indexOf(copyNum[999]);
    }
}