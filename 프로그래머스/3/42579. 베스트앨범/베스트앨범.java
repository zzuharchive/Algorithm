import java.util.*;
class Album implements Comparable<Album>{
    int num;
    int plays;
    
    public Album(int num, int plays){
        this.num = num;
        this.plays = plays;
    }
    @Override
    public int compareTo(Album a){
        if(a.plays == plays){
            return num - a.num;
        }
        return a.plays - plays;
    }
}
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> playMap = new HashMap<>();
        Map<String, List<Album>> albumMap = new HashMap<>();
        
        for(int i = 0; i<genres.length; i++){
            int play = playMap.getOrDefault(genres[i], 0);
            playMap.put(genres[i], plays[i] + play);
            
            List<Album> aList = albumMap.getOrDefault(genres[i], new ArrayList<>());
            aList.add(new Album(i, plays[i]));
            albumMap.put(genres[i], aList);
        }
        
        for(String key : albumMap.keySet()){
            Collections.sort(albumMap.get(key));
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(playMap.entrySet());
        
        list.sort((a, b) -> b.getValue() - a.getValue());

        List<Integer> answer = new ArrayList<>();
        
        for(Map.Entry<String, Integer> e : list){
            String genre = e.getKey();
            List<Album> albums = albumMap.get(genre);
            
            for(int i = 0; i<Math.min(2, albums.size()); i++){
                answer.add(albums.get(i).num);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}