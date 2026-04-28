/*해시맵 - 베스트 앨범*/
package structure.hashmap.best_album;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JungHaewon {
    public static void main(String[] args){
        Solution sol = new Solution();

        String[] genres = {
                "classic", "pop", "classic", "classic", "pop"
        };
        int[] plays = {
                500, 600, 150, 800, 2500
        };
        int[] answer = sol.solution(genres, plays);
        for (int x : answer ){
            System.out.print(x+" ");
        }
    }

    static class Solution {
        public int[] solution(String[] genres, int[] plays){
            HashMap<String, Integer> playCount = new HashMap<>();
            HashMap<String, List<int[]>> genresMap = new HashMap<>();

            for (int i = 0; i < genres.length; i++){
                playCount.merge(genres[i], plays[i], Integer::sum);
                /*playCount pop:3100, classic:1450*/
                genresMap.putIfAbsent(genres[i], new ArrayList<>());
                //genresMap에 장르 키가 없으면 빈 리스트 생성
                List<int[]> list = genresMap.get(genres[i]);
                //list는 복사본이 아니라 genresMap 안의 리스트를 "가리키는 화살표"
                list.add(new int[]{i, plays[i]});
                /*classic -> [[0,500], [2,150], [3,800]]
                  pop -> [[1,600], [4,2500]]  */
            }

            List<String> keySet = new ArrayList<>(playCount.keySet());
            //keySet()은 Map의 key들만 뽑아오는 것. ["classic", "pop"]
            //keySet()은 Set이라 정렬이 불편하니까 ArrayList로 복사해서 List로 만든거야.
            keySet.sort( (a,b) -> playCount.get(b) - playCount.get(a));
            //내림차순 정렬. ["pop", "classic"]

            List<Integer> result = new ArrayList<>();
            //최종으로 선택된 노래의 인덱스를 담을 리스트 만들기
            for (String genre : keySet) {
                List<int[]> list = genresMap.get(genre);

                list.sort((a, b) -> {
                    if (b[1] == a[1]) return a[0] - b[0];
                    //2순위: 재생수가 같으면 고유번호(인덱스) 작은 게 앞으로
                    //a[0] = 노래 인덱스. a[1] = 재생 수
                    return b[1] - a[1];
                    //1순위: 재생수 큰 게 앞으로
                });

                result.add(list.get(0)[0]);
                if (list.size() > 1) {
                    result.add(list.get(1)[0]);
                }
                //list.get(0)[0] 은 그 노래의 인덱스. list 크기가 2 이상일 때만 추가
            }
            return result.stream().mapToInt(i->i).toArray();
           //프로그래머스 반환 타입에 맞게 List<Integer> 를 int[]로 변환
        }
    }
}
