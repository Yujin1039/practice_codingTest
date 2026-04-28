import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> cmp = new HashMap<>();
        for(int i=0; i<completion.length; i++){
            cmp.put(completion[i], cmp.getOrDefault(completion[i], 0)+1);
        }
        //System.out.println(cmp);
        for(int i=0; i<participant.length; i++){
            if(cmp.containsKey(participant[i]) && cmp.get(participant[i]) >= 1){
                cmp.put(participant[i], cmp.get(participant[i])-1);
            } else {
                return participant[i];
            }
        }
        
        return answer;
    }
}