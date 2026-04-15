import java.util.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Collections.*;

public class Main {   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String L = st.nextToken();
        int LD = Integer.parseInt(L.substring(0,3));
        int LH = Integer.parseInt(L.substring(4,6));
        int LM = Integer.parseInt(L.substring(7,9));
        int F = Integer.parseInt(st.nextToken());

        // 형식 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        Map<String,HashMap<String, String>> map = new HashMap<>();
        Map<String,Long> fMap = new HashMap<>();
        for(int i=0; i<N; i++){
            String[] info = br.readLine().split(" ");
            LocalDateTime dateTime = LocalDateTime.parse(info[0]+" "+info[1], formatter);

            if(!map.containsKey(info[3]) || !map.get(info[3]).containsKey(info[2])){                  
                LocalDateTime future = dateTime.plusDays(LD).plusHours(LH).plusMinutes(LM); // 반납기한 계산
                fMap.putIfAbsent(info[3],0L);
                HashMap<String, String> part = map.computeIfAbsent(info[3], k -> new HashMap<>());
                part.put(info[2],future.format(formatter));
                map.put(info[3], part);
                
            } else {
                LocalDateTime future = LocalDateTime.parse(map.get(info[3]).get(info[2]),formatter);
                if(future.isBefore(dateTime)){
                    long penalty = ChronoUnit.MINUTES.between(future, dateTime) * F; // 벌금 계산
                    fMap.put(info[3], fMap.get(info[3])+penalty);  
                }
                map.get(info[3]).remove(info[2]);
            }
        }

        List<String> name = new ArrayList<>(fMap.keySet());
        Collections.sort(name);
        for(String nm: name){
            if(fMap.get(nm) != 0L) sb.append(nm+" "+fMap.get(nm)+"\n");
        }
        System.out.println(sb.toString().equals("") ? "-1":sb.toString());
    }
}