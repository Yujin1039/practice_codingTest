class Solution {
    public int solution(int n) {
        int pizza = 0;
        if(n % 6 == 0) pizza = n/6;
        else if(n % 3 == 0) pizza = n/3;
        else if(n % 2 == 0) pizza = n/2;
        else pizza = n;
        return pizza;
    }
}