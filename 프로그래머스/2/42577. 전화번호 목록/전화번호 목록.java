import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> set = new TreeSet<>();
        for(int i=0; i<phone_book.length; i++){
            set.add(phone_book[i]);
        }
        
        List<String> list = new ArrayList<>(set);
        for(int i=1; i<list.size(); i++){
            if(list.get(i).startsWith(list.get(i-1))) return false;
        }
        return answer;
    }
}