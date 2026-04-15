import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Double> scoreTrans = new HashMap<>(){{
            put("A+",4.5);
            put("A0",4.0);
            put("B+",3.5);
            put("B0",3.0);
            put("C+",2.5);
            put("C0",2.0);
            put("D+",1.5);
            put("D0",1.0);
            put("F",0.0);
        }};
        
        String subject = "";
        double sum = 0;
        double scount = 0;
        while((subject = br.readLine()) != null){
            String[] scoreList = subject.split(" ");
            if(!scoreList[2].equals("P")){
                sum += Double.parseDouble(scoreList[1]) * scoreTrans.get(scoreList[2]);
                scount += Double.parseDouble(scoreList[1]);
            }            
        }

        System.out.println(sum/scount);
    }
}