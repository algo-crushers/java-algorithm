package structure.hashmap.전화번호목록;

import java.util.HashMap;
import java.util.Map;

public class 박유빈 {
    public static void main(String[] args) {
        박유빈 instance = new 박유빈();
        String[] arr1 = {"119", "97674223", "1195524421"};
        System.out.println(instance.solution(arr1));

        String[] arr2 = {"123","456","789"};
        System.out.println(instance.solution(arr2));

        String[] arr3 = {"12","123","1235","567","88"};
        System.out.println(instance.solution(arr3));

    }

    public boolean solution(String[] phone_book) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String phone: phone_book) {
            map.put(phone, 1);
        }

        for (String phone: phone_book) {
            for (int i = 0; i < phone.length(); i++) {
                if (map.containsKey(phone.substring(0, i))) {
                    return false;
                }
            }
        }

        return true;
    }
}
