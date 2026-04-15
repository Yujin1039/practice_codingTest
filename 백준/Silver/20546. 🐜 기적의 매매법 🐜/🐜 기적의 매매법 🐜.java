import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> stock = new ArrayList<>();
        int last = 0;
        while (st.hasMoreTokens()) {
            last = Integer.parseInt(st.nextToken());
            stock.add(last);
        }

        // 준현이 자산
        int sMoney1 = money;
        int stock_bnp = 0;
        for(int stk : stock){
            if(sMoney1 >= stk){
                stock_bnp += sMoney1 / stk;
                sMoney1 = sMoney1 % stk;
            }
        }
        int bnp = last*stock_bnp + sMoney1;

        // 성민이 자산
        int sMoney2 = money;
        int stock_tim = 0;
        int prev = 0;
        int status = 0;
        int plus = 0; int minus = 0;
        for(int i=1; i<stock.size(); i++){
            int cur = stock.get(i);
            if(cur > prev) {
                if(status == 1) plus++;
                else {
                    plus = 1; minus = 0;
                    status = 1;
                }                
            } else if(cur < prev) {
                if(status == -1) minus++;
                else {
                    plus = 0; minus = 1;
                    status = -1;
                }                
            } else {
                plus = 0; minus = 0;
                status = 0;
            }

            if(plus == 3 && status == 1){
                sMoney2 += stock_tim * cur;
                stock_tim = 0;
                plus--;
            } else if(minus == 3 && status == -1){                
                if(sMoney2 >= cur){
                    stock_tim += sMoney2 / cur;
                    sMoney2 = sMoney2 % cur;
                }
                minus--;
            }   
            prev = cur;
        }
        int tim = last*stock_tim + sMoney2;
        
        if(bnp > tim){
            System.out.println("BNP");
        } else if(bnp < tim){
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }
}