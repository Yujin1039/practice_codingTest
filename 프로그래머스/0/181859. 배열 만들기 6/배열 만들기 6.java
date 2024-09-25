import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){
            if(!stk.isEmpty() && stk.peekLast() == arr[i]){
                stk.pollLast();
            }else{
                stk.offerLast(arr[i]);
            }
        }
        return stk.isEmpty() ? new int[]{-1}:stk.stream().mapToInt(Integer::intValue).toArray();
    }
}