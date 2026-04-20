package structure.hashmap;

import java.util.HashMap;
import java.util.Map;

public class 의상 {
    public static void main(String[] args) {
        의상 instance = new 의상();
        String[][] clothes1 = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(instance.solution(clothes1));
        String[][] clothes2 = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};
        System.out.println(instance.solution(clothes2));
    }

    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();
        for (String[] clothe : clothes) {
            clothesMap.merge(clothe[1], 1, Integer::sum);
        }

        int result = 1;
        for (int count : clothesMap.values()) {
            result *= count + 1;
        }

        return result - 1;
    }
}
