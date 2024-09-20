class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int[] query:queries){
            int s = query[0];
            int e = query[1];
            while(s <= e){
                arr[s]++;
                s++;
            }
        }
        return arr;
    }
}