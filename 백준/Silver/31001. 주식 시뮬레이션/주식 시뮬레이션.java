import java.util.*;
import java.io.*;

public class Main {    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 회사 수
        long M = Long.parseLong(st.nextToken()); // 현금
        int Q = Integer.parseInt(st.nextToken()); // 입력 메뉴 수
        Map<String,Long> info = new HashMap<>(); // 회사 주가 정보
        Map<Integer, List<String>> groupInfo = new HashMap<>(); // 회사 그룹 정보
        Map<String,Integer> wallet = new HashMap<>(); // 보유 주식 정보

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int group = Integer.parseInt(st.nextToken());
            String b = st.nextToken();
            long value = Long.parseLong(st.nextToken());
            info.put(b, value);
            groupInfo.computeIfAbsent(group, k -> new ArrayList<>()).add(b);
        }

        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            
            if(cmd == 1){
                String A = st.nextToken();
                int B = Integer.parseInt(st.nextToken());

                if(M >= info.get(A)*B){
                    M -= info.get(A)*B;
                    wallet.put(A, wallet.getOrDefault(A, 0)+B);
                }
            } else if(cmd == 2){
                String A = st.nextToken();
                int B = Integer.parseInt(st.nextToken());
                int num = wallet.getOrDefault(A, 0);
                
                if(B >= num){
                    M += info.get(A)*num;
                    wallet.put(A, 0);
                } else if(num > 0){
                    M += info.get(A)*B;
                    wallet.put(A, wallet.get(A)-B);
                }
            } else if(cmd == 3){
                String A = st.nextToken();
                int C = Integer.parseInt(st.nextToken());
                info.put(A, Math.max(info.get(A)+C,0));
                
            } else if(cmd == 4){
                int D = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                List<String> cpList = groupInfo.get(D);

                if(cpList != null){
                    for(String cp: cpList){
                        info.put(cp, Math.max(info.get(cp)+C,0));
                    }
                }
                
            } else if(cmd == 5){
                int D = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                List<String> cpList = groupInfo.get(D);

                if(cpList != null){
                    for(String cp: cpList){
                        long value = info.get(cp) * (100+E) / 100;
                        value = value / 10 * 10;
                        info.put(cp, value);
                    }
                }
                
            } else if(cmd == 6){
                sb.append(M+"\n");
            } else if(cmd == 7){
                Set<String> cpList = wallet.keySet();
                long cur = M;
                for(String cp:cpList){
                    cur += wallet.get(cp) * info.get(cp);
                }
                sb.append(cur+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}