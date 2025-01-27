import java.util.*;
import java.io.*;

public class Main {     
    static int[][] xy = new int[][]{{1,-1,0,0,-1,-1,1,1},{0,0,1,-1,-1,1,-1,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        int K = Integer.parseInt(st.nextToken()); 
        
        char[][] alphabet = new char[N][M];   
        Map<Character,List<int[]>> map = new HashMap<>();
        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<M;j++){
                char c = str.charAt(j);
                alphabet[i][j] = c;
                map.computeIfAbsent(c,key -> new ArrayList<>()).add(new int[]{i,j});
            }
        }

        Map<String,Integer> answer = new HashMap<>();
        for(int k=0;k<K;k++){
            String word = br.readLine();
            if(answer.containsKey(word)){
                sb.append(answer.get(word)).append("\n");
                continue;
            }
            int sum = 0;
            if(map.containsKey(word.charAt(0))) {
                if(word.length() == 1){
                    sum = map.get(word.charAt(0)).size();
                }else {
                    List<int[]> list = new ArrayList<>(map.get(word.charAt(0)));
                    for(int[] cur:list){
                        Stack<int[]> stack = new Stack<>();
                        stack.push(new int[]{cur[0],cur[1],0});
                        sum += godLikeCases(alphabet,word,stack,N,M);                   
                    }
                }
            }
            answer.put(word,sum);
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
    static int godLikeCases(char[][] alphabet,String word,Stack<int[]> stack,int N,int M){  
        int cases = 0;        
        while(!stack.isEmpty()){
            int[] cur = stack.pop();
            for(int i=0;i<8;i++){
                int x = (cur[0] + xy[0][i] + N) % N;
                int y = (cur[1] + xy[1][i] + M) % M;
                
                if(alphabet[x][y] == word.charAt(cur[2]+1)){
                    if(cur[2]+1 == word.length()-1){
                        cases++;
                        continue;
                    }
                    stack.push(new int[]{x,y,cur[2]+1});
                }
            }
        }
        return cases;
    }
}