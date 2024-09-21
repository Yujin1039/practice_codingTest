/*
String클래스의 replace 메서드
-> 문자열.replace("바꿀 문자열","바뀌는 문자열")
   해당 조건 만족시 모두 변경!!
*/
class Solution {
    public String solution(String myString) {
        myString = myString.toLowerCase();
        myString = myString.replace("a","A");
        return myString;
    }
}