import java.util.*;

class Solution {
    public String solution(String rsp) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(2,0);
        map.put(0,5);
        map.put(5,2);
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<rsp.length();i++){
            sb.append(map.get(rsp.charAt(i)-'0'));
        }
        return sb.toString();
    }
}