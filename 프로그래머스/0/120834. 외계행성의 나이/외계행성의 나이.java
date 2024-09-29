class Solution {
    public String solution(int age) {
        String answer = "";
        String aGe = age + "";
        for(int i=0;i<aGe.length();i++){
            answer += (char)(aGe.charAt(i) + 49);
        }
        return answer;
    }
}