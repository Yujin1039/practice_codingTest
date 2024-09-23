import java.util.*;

class Solution {
    public int solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder(pat);
        for(int i=0;i<pat.length();i++){
            if(sb.charAt(i)=='A') sb.setCharAt(i,'B');
            else sb.setCharAt(i,'A');
        }
        return myString.indexOf(sb.toString()) == -1 ? 0:1;
    }
}