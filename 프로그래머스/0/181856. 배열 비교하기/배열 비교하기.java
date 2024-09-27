class Solution {
    public static int addAll(int[] arr){
        int sum = 0;
        for(int i:arr){
            sum += i;
        }
        return sum;
    }
    public int solution(int[] arr1, int[] arr2) {
        int answer = -1;
        int len = arr1.length - arr2.length;
        
        if(len == 0){
            int sum = addAll(arr1) - addAll(arr2);
            if(sum == 0) answer = 0;
            else if(sum > 0) answer = 1;
        }else if(len > 0){
            answer = 1;
        }
        return answer;
    }
}