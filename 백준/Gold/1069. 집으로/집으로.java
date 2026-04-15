import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        double distance = Math.sqrt(X*X + Y*Y);
        double time = distance;

        if(distance % D == 0){
            time = Math.min(time, distance/D*T);
        } else {
            int common = T*(int)(distance/D);
            double rest = distance%D;
            
            // 점프 후 걷기
            if(common > 0) {
                time = Math.min(time, common+rest);
                time = Math.min(time, common+T+(D*(distance/D+1)-distance));
                time = Math.min(time, common+T); // 점프만
            } else if(common == 0) {
                time = Math.min(time, T+D-distance);
                time = Math.min(time, T*2); // 점프만
            }            
        }
        System.out.println(time);
    }
}