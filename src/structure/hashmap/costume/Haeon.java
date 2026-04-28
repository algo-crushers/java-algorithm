package structure.hashmap.costume;

import java.util.HashMap;

/*출처: https://iam-joy.tistory.com/21*/
public class Haeon {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[][] clothes1 = {
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };

        System.out.println(sol.solution(clothes1)); // 5
    }

    static class Solution {
        public int solution(String[][] clothes) {
            HashMap<String, Integer> clothesMap = new HashMap<>();

            for (String[] cloth : clothes) {
                String type = cloth[1];
                clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1);
            }

            int answer = 1;
            for (String key : clothesMap.keySet()) {
                int count = clothesMap.get(key);
                answer *= (count + 1);
            }

            return answer - 1;
        }
    }
}

/* Hash 정리
-Hash는 전화번호부. key:value
-정수가 아닌 key를 담을수 있어 배열로 담을 수없는 정보를 담을 수 있다.
-O(1)
-스트링 기반으로 자료를 관리해야할 때 사용
- 대표 함수 :
HashMap.put["A", true] : 값 입력
HashMap["A"] = true : 값 가져오기. get과 같다.
hashmap.get("A") : 값 가져오기
getOrDefault : A가 있다면, A의 value를 반환 하고, A가 없다면, False를 반환

- 니콜라스 설명 : index, Value 테이블이 있다. pizza, cake, taco를 저장할때
pizza는 5글자 이므로 index 5, cake는 index 4에 저장 가능하다.
pizza : 5
cake : 4
만약 taco를 저장한다면? 4글자이므로 cake과 충돌(collision)이 생긴다.
이를 해결 하기 위한 대표 방법이 분리 체이닝(separate Chaining), 오픈 어드레싱(Open Addressing)
- 분리 체이닝 : 충돌 발생 시 체인으로 연결. 각 버킷(배열 슬롯)을 연결 리스트(또는 트리)로 만들어, 같은 인덱스로 매핑된 요소를 리스트에 추가.
- 오픈 어드레싱 : 배열 내의 다른 빈 슬롯 탐색.

* */
