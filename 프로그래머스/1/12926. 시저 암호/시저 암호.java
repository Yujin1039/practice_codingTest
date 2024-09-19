import java.util.*;

class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == 32){
                continue;
            }else if(c > 96){
                c += n;
                if(c > 122) c -= 26;
            }else{
                c += n;
                if(c > 90) c -= 26;
            }
            sb.setCharAt(i,c);
        }
        return sb.toString();
    }
}