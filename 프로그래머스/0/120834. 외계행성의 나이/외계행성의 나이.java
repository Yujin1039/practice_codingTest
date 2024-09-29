class Solution {
    public String solution(int age) {
        StringBuilder sb = new StringBuilder();
        String aGe = age + "";
        for(int i=0;i<aGe.length();i++){
            sb.append((char)(aGe.charAt(i) + 49));
        }
        return sb.toString();
    }
}