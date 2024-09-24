import java.util.*;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        List<Integer> list = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            if(flag[i]){
                for(int j=0;j<2*arr[i];j++){
                    list.add(arr[i]);
                }
            }else{
                for(int j=0;j<arr[i];j++){
                    list.remove(list.size() - 1);
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}