import java.util.*;

class Solution {
    public String solution(String n_str) {
        StringBuilder sb = new StringBuilder(n_str);
        while(sb.charAt(0) == '0'){
            sb.delete(0,1);
        }
        return sb.toString();
    }
}