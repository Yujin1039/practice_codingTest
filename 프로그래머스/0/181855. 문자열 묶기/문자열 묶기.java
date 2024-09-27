import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int[] num = new int[31];
        for(String s:strArr){
            num[s.length()]++;
        }
        Arrays.sort(num);
        return num[30];
    }
}