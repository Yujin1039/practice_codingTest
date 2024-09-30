import java.math.BigInteger;

class Solution {
    public static BigInteger factorial(int from, int to) {
        BigInteger result = BigInteger.ONE;
        for (int i = from; i > from - to; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
    
    public int solution(int balls, int share) {
        if (share > balls / 2) {
            share = balls - share;  
        }
        BigInteger result = factorial(balls, share).divide(factorial(share, share));
        return result.intValue();
    }
}
