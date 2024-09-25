import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        int[] result = new int[k];
        for(int i:arr){
            if(!list.contains(i)) list.add(i);
        }
        
        for(int i=0;i<k;i++){
            if(i >= list.size()){
                result[i] = -1;
            }else{
                result[i] = list.get(i);
            }
        }
        return result;
    }
}