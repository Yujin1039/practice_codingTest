import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] cb;
    static List<List<List<Integer>>> game;
    static int[][] pieces;

    static int changeDir(int k){       
        // 방향 변동
        int d = 0;
        if(pieces[k][2] == 1) d = 2;
        else if(pieces[k][2] == 2) d = 1;
        else if(pieces[k][2] == 3) d = 4;
        else d = 3; 

        return d;
    }

    static int movePiece(int k, int r, int c){
        int pr = pieces[k][0];
        int pc = pieces[k][1];
        int d = pieces[k][2];
        List<Integer> pList = game.get(pr).get(pc);

        // 이동
        if(d == 1)  c++;
        else if(d == 2) c--;
        else if(d == 3) r--;
        else if(d == 4) r++;       

        // 체스판을 벗어나거나 파란 칸일 때 
        if (r <= 0 || r > N || c <= 0 || c > N || cb[r][c] == 2) {
            d = changeDir(k);
            pieces[k][2] = d;

            r = pr + (d == 3 ? -1 : d == 4 ? 1 : 0);
            c = pc + (d == 1 ? 1 : d == 2 ? -1 : 0);

            if (r <= 0 || r > N || c <= 0 || c > N || cb[r][c] == 2) return 1;
        }
        
        // 빨간 칸일 때
        if(cb[r][c] == 1){
            Collections.reverse(pList);           
        } 

        // 이동 변화가 없을 때
        if(r == pr && c == pc) return 1;
        
        // 새로운 위치로 이동
        game.get(r).get(c).addAll(pList);
        for(int num: game.get(r).get(c)){
            pieces[num][0] = r;
            pieces[num][1] = c;
        }

        // 기존 위치에서 제거
        pList.clear();

        // 종료 여부 확인
        if(game.get(r).get(c).size() >= 4) return 0;
       
        return 1;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        cb = new int[N+1][N+1]; // 체스판        
        int K = Integer.parseInt(st.nextToken()); // 말의 개수
        pieces = new int[K+1][3]; // 말 상태 표시
        game = new ArrayList<>(); // 게임 상태 표시

        // 체스판 상태 표시
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                cb[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 초기 위치 표시
        for(int i=0; i<=N; i++){
            game.add(new ArrayList<>());
            for(int j=0; j<=N; j++){
                game.get(i).add(new LinkedList<>());
            }
        }

        for(int i=1; i<=K; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pieces[i][0] = r;
            pieces[i][1] = c;
            pieces[i][2] = d;
            game.get(r).get(c).add(i);
        }

        // 게임 진행
        int turn = 1;
        while (turn < 1000) {
            for(int i=1; i<=K; i++){
                int r = pieces[i][0];
                int c = pieces[i][1];
                
                // 제일 앞에 있는지 확인
                if(game.get(r).get(c).get(0) == i){
                    int result = movePiece(i, r, c);
                    if(result == 0) {
                        System.out.println(turn);
                        return;
                    } 
                }                                
            }
            turn++;           
        }

        // 결과 출력
        System.out.println(-1);
    }
}