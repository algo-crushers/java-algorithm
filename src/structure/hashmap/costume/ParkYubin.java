package structure.hashmap.costume;

import java.util.HashMap;
import java.util.Map;

public class ParkYubin {
    public static void main(String[] args) {
        ParkYubin instance = new ParkYubin();
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
