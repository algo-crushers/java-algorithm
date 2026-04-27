package structure.hashmap.의상;

import java.util.HashMap;
import java.util.Map;

public class 한다현 {
    public static void main(String[] args) {
        Solution s = new Solution();

        String[][] clothes1 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String[][] clothes2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

        System.out.println(s.solution(clothes1));
        System.out.println(s.solution(clothes2));
    }
}

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (String[] c : clothes) {
            map.merge(c[1], 1, Integer::sum);
        }
        System.out.println(map);

        int result = 1;
        for (Integer i : map.values()) {
            result *= (i + 1);
        }
        return result - 1;
    }
}
