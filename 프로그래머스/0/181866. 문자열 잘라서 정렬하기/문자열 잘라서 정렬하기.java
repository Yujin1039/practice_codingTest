import java.util.*;

class Solution {
    public String[] solution(String myString) {
        String[] str = myString.split("x");                
        return Arrays.stream(str).filter(s -> !s.equals("")).sorted().toArray(String[]::new);
    }
}