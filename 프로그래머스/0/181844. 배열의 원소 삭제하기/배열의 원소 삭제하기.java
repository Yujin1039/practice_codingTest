import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        Arrays.sort(delete_list);
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(Arrays.binarySearch(delete_list,arr[i]) < 0){
                list.add(arr[i]);
            }
        }
        
        return list.stream().mapToInt(i -> i.intValue()).toArray();
    }
}