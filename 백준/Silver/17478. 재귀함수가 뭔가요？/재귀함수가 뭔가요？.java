import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static String[] ask;
    static String[] ans;
    static StringBuilder sb;
    
    static void askQuest(int m){
        String cmd = "_".repeat(4*m);

        if(m == 0) sb.append(ask[0]);
        
        if(m != n){
            for(int i=1; i<5; i++){
                sb.append(cmd);
                sb.append(ask[i]);
            }
        } else {
            for(int i=0; i<3; i++){
                sb.append(cmd);
                sb.append(ans[i]);
            }
            return;
        }
        
        askQuest(m+1);
        sb.append(cmd);
        sb.append(ask[5]);         
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ask = new String[6];
        ask[0] = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
        ask[1] = "\"재귀함수가 뭔가요?\"\n";
        ask[2] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
        ask[3] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
        ask[4] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
        ask[5] = "라고 답변하였지.\n";

        ans = new String[3];
        ans[0] = ask[1];
        ans[1] = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
        ans[2] = ask[5];

        sb = new StringBuilder();
        askQuest(0);
        System.out.println(sb.toString());
    }
}