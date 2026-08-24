import java.util.*;

class Solution {
    static class Song {
        int id;
        int play;
        
        Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
    }
    
    static class GenreInfo {
        int totalPlay;
        Song first;
        Song second;
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, GenreInfo> map = new HashMap<>();
        
        for (int i=0; i<genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            map.putIfAbsent(genre, new GenreInfo());
            GenreInfo info = map.get(genre);
            
            info.totalPlay += play;
            Song current = new Song(i, play);
            
            if (isBetter(current, info.first)) {
                info.second = info.first;
                info.first = current;
            }
            else if (isBetter(current, info.second)) {
                info.second = current;
            }
        }
        
        List<String> genreList = new ArrayList<>(map.keySet());
        genreList.sort((a, b) -> Integer.compare(map.get(b).totalPlay, map.get(a).totalPlay));
        
        List<Integer> answerList = new ArrayList<>();
        
        for (String genre : genreList) {
            GenreInfo info = map.get(genre);
            
            if (info.first != null) {
                answerList.add(info.first.id);
            }
            if (info.second != null) {
                answerList.add(info.second.id);
            }
        }
        
        int[] answer = new int[answerList.size()];
        for (int i=0; i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    private boolean isBetter(Song a, Song b) {
        if (b == null) return true;
        if (a.play != b.play) return a.play > b.play;
        return a.id < b.id;
    }
}