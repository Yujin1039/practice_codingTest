import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> playCnt = new HashMap<>();
        Map<String, List<Integer>> songList = new HashMap<>();        
        for(int i=0; i<genres.length; i++){
            playCnt.put(genres[i], playCnt.getOrDefault(genres[i],0)+plays[i]);
            songList.computeIfAbsent(genres[i],(k -> new ArrayList<>())).add(i);
        }
        
        List<String> keySet = new ArrayList<>(playCnt.keySet());
        Collections.sort(keySet, (o1,o2) -> playCnt.get(o2)-playCnt.get(o1));
        
        
        for(String key:keySet){
            List<Integer> list  = songList.get(key);
            Collections.sort(list, (o1,o2) -> plays[o2]-plays[o1]);
            answer.add(list.get(0));
            if(list.size() > 1) answer.add(list.get(1));
        }
        
        int[] ans = new int[answer.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = answer.get(i);
        }
        return ans;
    }
}