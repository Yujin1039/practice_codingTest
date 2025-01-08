import java.util.*;
import java.io.*;

public class Main {        
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] time = new int[3];
        for(int i=0;i<3;i++){
            StringTokenizer standard = new StringTokenizer(st.nextToken(),":");
            int hour = Integer.parseInt(standard.nextToken());
            int minute = Integer.parseInt(standard.nextToken());
            time[i] = hour*60 + minute;
        }

        String record;
        int attend = 0;
        Set<String> present = new HashSet<>();
        while((record = br.readLine()) != null){
            st = new StringTokenizer(record,": ");
            int hour = Integer.parseInt(st.nextToken());
            int minute = Integer.parseInt(st.nextToken());
            int perT = hour*60 + minute;
            String name = st.nextToken();

            if(perT <= time[0]){
                present.add(name);
            }else if(perT >= time[1] && perT <= time[2]){
                if(present.contains(name)) {
                    present.remove(name);
                    attend++;
                }
            }
        }
        System.out.println(attend);
    }
}