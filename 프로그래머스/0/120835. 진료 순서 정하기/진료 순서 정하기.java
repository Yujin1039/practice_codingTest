import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int[] copyE = emergency.clone();
        Arrays.sort(copyE);
        
        Map<Integer,Integer> map = new HashMap<>();
        int em = 0;
        for(int i=0;i<copyE.length;i++){
            map.put(copyE[i],em++);
        }
        
        for(int i=0;i<copyE.length;i++){
            emergency[i] = copyE.length - map.get(emergency[i]);
        }
        return emergency;
    }
}