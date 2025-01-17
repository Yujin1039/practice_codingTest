import java.util.*;
import java.io.*;

public class Main { 
    static int max = 0;
    static void bindNum(List<Integer> list,int pre){
        for(int num1:list){
            if(pre == 0) pre += num1;
            else{
                max += Math.max(pre * num1,pre+num1);
                pre = 0;
            }
        }
        max += pre;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int n = Integer.parseInt(br.readLine()); 
        
        List<Integer> negative = new ArrayList<>();
        List<Integer> positive = new ArrayList<>();
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());
            if(num > 0) positive.add(num);
            else negative.add(num);
        }
        Collections.sort(negative);
        Collections.sort(positive);
        Collections.reverse(positive);

        bindNum(negative,0);
        bindNum(positive,0);
        
        System.out.println(max);
    }
}