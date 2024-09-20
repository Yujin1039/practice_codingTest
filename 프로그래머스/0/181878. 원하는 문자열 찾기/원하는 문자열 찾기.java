class Solution {
    public int solution(String myString, String pat) {
        for(int i=0;i<=myString.length()-pat.length();i++){
            String substr = myString.substring(i,i+pat.length());
            if(substr.equalsIgnoreCase(pat)) return 1;
        }
        return 0;
    }
}