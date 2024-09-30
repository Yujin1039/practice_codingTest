class Solution {
    public String solution(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int add = 0;
        
        for(int i=1;i<=a.length() || i<=b.length();i++){
            int an = a.length()-i >= 0 ? a.charAt(a.length()-i) - '0':0;
            int bn = b.length()-i >= 0 ? b.charAt(b.length()-i) - '0':0;
            int sub = an + bn;
            if(add+sub%10 >= 10){
                sb.insert(0,0);
            }else{
                sb.insert(0,add+sub%10+"");
            }
            
            if(sub >= 10 || add+sub%10 >= 10) add = 1;
            else add = 0;
        }
        if(add == 1) sb.insert(0,add+"");
        return sb.toString();
    }
}