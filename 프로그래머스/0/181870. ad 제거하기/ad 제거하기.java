import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        List<String> list = new ArrayList<>();
        for(String s:strArr){
            if(s.indexOf("ad") == -1) list.add(s);
        }        
        return list.toArray(new String[list.size()]);
    }
}