import java.util.*;
import java.io.*;
import java.util.Collections.*;

public class Main {   
    static int bindList(List<Integer> list){
        int sum = 0;
        boolean isBinded = false;
        
        for(int i=list.size()-1; i>0; i--){
            int plus = list.get(i)+list.get(i-1);
            int multiple = list.get(i)*list.get(i-1);

            if(plus >= multiple) sum += list.get(i);
            else{
                sum += multiple;
                if(i == 1) isBinded = true;
                i--;
            }
        }
        if(!isBinded) sum += list.get(0);
        
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            if(num > 0) pos.add(num);
            else neg.add(num);
        }
        Collections.sort(pos);
        Collections.sort(neg, Collections.reverseOrder());

        int sum = 0;
        if(pos.size() > 0) sum += bindList(pos);
        if(neg.size() > 0) sum += bindList(neg);       
        
        System.out.println(sum);
    }
}