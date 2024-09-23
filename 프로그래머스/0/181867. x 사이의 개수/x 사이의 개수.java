import java.util.*;
/* split 메서드의 마지막 공백 추가
.split("구분자",-1) <- 두번째 인자로 "-1"을 사용
*/

class Solution {
    public int[] solution(String myString) {
        String[] splitStr = myString.split("x",-1);
        int[] answer = new int[splitStr.length];
        for(int i=0;i<answer.length;i++){
            answer[i] = splitStr[i].length();
        }
        return answer;
    }
}