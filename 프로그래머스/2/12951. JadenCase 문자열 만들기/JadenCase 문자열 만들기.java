import java.util.regex.*;

class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        
        return Pattern.compile("(^| )(\\S)").matcher(s)
                    .replaceAll(m -> m.group(1)+m.group(2).toUpperCase());
    }
}