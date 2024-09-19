import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished){ 
        int cnt = 0;
        for(int i=0;i<finished.length;i++){
            if(!finished[i]){
                cnt++;
            }
        }
        String[] answer = new String[cnt];
        int n = 0;           
        for(int i=0;i<todo_list.length;i++){
            if(!finished[i]){
                answer[n++] = todo_list[i];
            }
        }
        return answer;
    }
}