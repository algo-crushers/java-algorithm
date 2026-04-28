package structure.hashmap.best_album;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HanDahyeon {
    public static void main(String[] args) {
        Solution s = new Solution();

        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(Arrays.toString(s.solution(genres, plays)));
    }

    static class Solution {
        public int[] solution(String[] genres, int[] plays) {

            HashMap<String, Integer> playCount = new HashMap<>();
            HashMap<String, List<int[]>> genresMap = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                playCount.merge(genres[i], plays[i], Integer::sum);

                genresMap.putIfAbsent(genres[i], new ArrayList<>());
                List<int[]> list = genresMap.get(genres[i]);
                list.add(new int[]{i, plays[i]});
            }

            List<String> keySet = new ArrayList<>(playCount.keySet());
            keySet.sort((a, b) -> playCount.get(b) - playCount.get(a));

            List<Integer> result = new ArrayList<>();

            for (String genre : keySet) {
                List<int[]> list = genresMap.get(genre);

                list.sort((a, b) -> {
                    if (b[1] == a[1]) return a[0] - b[0];
                    return b[1] - a[1];
                });

                result.add(list.get(0)[0]);

                if (list.size() > 1) {
                    result.add(list.get(1)[0]);
                }
            }
            return result.stream().mapToInt(i -> i).toArray();
        }
    }
}
