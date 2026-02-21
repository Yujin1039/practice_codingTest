class Solution {
    public static char toUpper(char c){
        if(c >= 'a' && c <= 'z'){
            return (char) (c-32);
        }
        return c;
    }
    
    public static char toLower(char c){
        if(c >= 'A' && c <= 'Z'){
            return (char) (c+32);
        }
        return c;
    }
    public String solution(String s) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(0, toUpper(sb.charAt(0)));
        for(int i=1; i<sb.length(); i++){
            if(sb.charAt(i-1) == ' '){
                sb.setCharAt(i, toUpper(sb.charAt(i)));
            } else {
                sb.setCharAt(i, toLower(sb.charAt(i)));
            }
        }
        return sb.toString();
    }
}