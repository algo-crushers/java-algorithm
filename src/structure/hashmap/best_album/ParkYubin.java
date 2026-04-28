package structure.hashmap.best_album;

import java.util.*;

public class ParkYubin {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(new ParkYubin().solution(genres, plays));

    }

    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르별 총 재생수 합산
        Map<String, Integer> genreTotal = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreTotal.merge(genres[i], plays[i], Integer::sum);
        }

        // 2. 장르를 총 재생수 기준 내림차순 정렬 → 순위(rank) 부여
        List<String> sortedGenres = new ArrayList<>(genreTotal.keySet());
        sortedGenres.sort((a, b) -> genreTotal.get(b) - genreTotal.get(a));

        Map<String, Integer> genreRank = new HashMap<>();
        for (int i = 0; i < sortedGenres.size(); i++) {
            genreRank.put(sortedGenres.get(i), i);
        }

        // 3. 곡 목록 생성: [인덱스, 재생수, 장르순위]
        int[][] songs = new int[genres.length][3];
        for (int i = 0; i < genres.length; i++) {
            songs[i][0] = i;
            songs[i][1] = plays[i];
            songs[i][2] = genreRank.get(genres[i]);
        }

        // 4. 정렬: 장르순위 오름차순 → 재생수 내림차순 → 인덱스 오름차순
        Arrays.sort(songs, (a, b) -> {
            if (a[2] != b[2]) return a[2] - b[2];
            if (a[1] != b[1]) return b[1] - a[1];
            return a[0] - b[0];
        });

        // 5. 장르별 최대 2곡 수집
        List<Integer> result = new ArrayList<>();
        int[] cnt = new int[sortedGenres.size()];

        for (int[] song : songs) {
            int rank = song[2];
            if (cnt[rank] < 2) {
                result.add(song[0]);
                cnt[rank]++;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
