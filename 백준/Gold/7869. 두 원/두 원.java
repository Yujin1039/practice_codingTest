import java.util.*;
import java.io.*;

public class Main {   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double x1 = Double.parseDouble(st.nextToken());
        double y1 = Double.parseDouble(st.nextToken());
        double r1 = Double.parseDouble(st.nextToken());

        double x2 = Double.parseDouble(st.nextToken());
        double y2 = Double.parseDouble(st.nextToken());
        double r2 = Double.parseDouble(st.nextToken());

        if(r2 > r1){
            double tmpX = x1;
            double tmpY = y1;
            double tmpR = r1;
            x1 = x2; y1 = y2; r1 = r2;
            x2 = tmpX; y2 = tmpY; r2 = tmpR;
        }

        // 원 중심 사이의 거리 구하기
        double dis = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));

        if(dis > r1+r2){ // 두 원이 겹치지 않을 때
            System.out.println(String.format("%.3f",0.0));
            
        } else if(r1 >= r2+dis){ // 한 원이 다른 원 내에 포함될 때
            System.out.println(String.format("%.3f",Math.PI*r2*r2));
            
        } else if(r1 < r2+dis && r1 > dis){ // 한 원의 중심이 다른 원 내에 포함될 때 
            
            // 원2로부터 공통 현까지의 거리
            double dc = (r1*r1-r2*r2-dis*dis)/(2*dis);
            
            // 공통 현 길이 구하기
            double chord = 2*Math.sqrt(r2*r2-dc*dc);    
            
            // 각 부채꼴 각도 구하기
            double ra1 = Math.acos((dc+dis)/r1)*2;
            double ra2 = Math.PI*2 - Math.acos(dc/r2)*2;
            
            // 부채꼴 넓이 구하기
            double sectors = r1*r1*0.5*ra1 + r2*r2*0.5*ra2;
            
            // 삼각형 넓이 구하기        
            double triangle = chord*dc*0.5 - chord*(dc+dis)*0.5;

            // 겹쳐진 원 넓이 구하기
            System.out.println(String.format("%.3f",sectors+triangle));
            
        } else { // 그 외 두 원이 겹칠 때
            // 원1로부터 공통 현까지의 거리
            double dc = (r1*r1-r2*r2+dis*dis)/(2*dis);
            
            // 공통 현 길이 구하기
            double chord = 2*Math.sqrt(r1*r1-dc*dc);    
    
            // 각 부채꼴 각도 구하기
            double ra1 = Math.asin(chord/2/r1)*2;
            double ra2 = Math.asin(chord/2/r2)*2;
    
            // 부채꼴 넓이 구하기
            double sectors = r1*r1*0.5*ra1 + r2*r2*0.5*ra2;
            
            // 사각형 넓이 구하기        
            double squre = dis*chord*0.5;
    
            // 겹쳐진 원 넓이 구하기
            System.out.println(String.format("%.3f",sectors-squre));
        }
    }
}