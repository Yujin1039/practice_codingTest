import java.util.*;

class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0,1).toUpperCase());
        
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i-1) == ' '){
                sb.append(s.substring(i,i+1).toUpperCase());
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }
}