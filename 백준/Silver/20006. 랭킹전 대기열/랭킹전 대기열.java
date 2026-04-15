import java.util.*;
import java.io.*;

class Info {
    int level;
    String nickname;

    public Info(int l, String n){
        this.level = l;
        this.nickname = n;
    }
} 

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        List<List<Info>> waitingRoom = new LinkedList<>();
        for(int i=0; i<p; i++){
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();

            boolean isNew = true;
            for (List<Info> list : waitingRoom) {
                if(list.size() < m && level >= list.get(0).level-10 && level <= list.get(0).level+10){
                    isNew = false;
                    list.add(new Info(level, nickname));
                    break;
                }
            }

            if(isNew){
                List<Info> room = new LinkedList<>();
                room.add(new Info(level, nickname));                
                waitingRoom.add(room);                                
            }
        }

        for (List<Info> list : waitingRoom) {
            Collections.sort(list, Comparator.comparing(info -> info.nickname));
            if(list.size() < m) sb.append("Waiting!\n");
            else sb.append("Started!\n");
            for(Info user : list){
                sb.append(user.level+" "+user.nickname+"\n");
            }
        }
        System.out.println(sb.toString());
    }
}