import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] str = myString.split("x");        
        List<String> list = new ArrayList<>();
        for(String s:str){
            if(s.length() != 0) list.add(s);
        }  
        Collections.sort(list);
        return list.toArray(String[]::new);
    }
}