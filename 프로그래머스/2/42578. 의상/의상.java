import java.util.*;

class Solution {
    static int factorial(int n, int c){
        if(c == 1) return n;        
        int rt = n * factorial(n-1, c-1);        
        return rt;
    }
    
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String,List<String>> map = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            String[] cloth = clothes[i];
            map.computeIfAbsent(cloth[1], k -> new ArrayList<>()).add(cloth[0]); // 메서드 정리!!
        }
        
        for(String key: map.keySet()){
            int size = map.get(key).size();
            answer *= (size+1);
        }
        return answer-1;
    }
}