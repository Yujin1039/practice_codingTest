class Solution {
    public static int gcd(int a, int b){
        if(a < b) return gcd(b,a);
        else{
            if(a == 0 || b == 0){
                return a != 0 ? a:b;
            }else{
                a = a % b;
                return gcd(b, a);
            }
        }
    }
    
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] answer = new int[2];
        int denomGcd = gcd(denom1,denom2);
        int denom = denom1 * denom2 / denomGcd;
        int numer = numer1 * (denom/ denom1) + numer2 * (denom/ denom2);
        int fractionGcd = gcd(numer, denom);
        answer[0] = numer / fractionGcd;
        answer[1] = denom / fractionGcd;
        return answer;
    }
}