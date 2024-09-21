class Solution {
    public String solution(String my_string, String alp) {
        char alP = (char)(alp.charAt(0) - 32);
        return my_string.replace(alp,String.valueOf(alP));
    }
}