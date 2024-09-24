import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] answer = myStr.split("a|b|c");
        List<String> list = new ArrayList<>();
        String[] answer2 = {"EMPTY"};
        for(String s:answer){
            if(!s.equals("")) list.add(s);
        }
        return list.size() == 0 ? answer2:list.toArray(String[]::new);
    }
}