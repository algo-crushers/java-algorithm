package structure.hashmap.phone_book;

import java.util.HashMap;

public class HanDahyeon {
    public static void main(String[] args) {
        Solution s = new Solution();

        String[] phone_book1 = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123","456","789"};
        String[] phone_book3 = {"12","123","1235","567","88"};

        System.out.println(s.solution(phone_book1));
        System.out.println(s.solution(phone_book2));
        System.out.println(s.solution(phone_book3));
    }

    static class Solution {
        public boolean solution(String[] phone_book) {

            String temp = "";
            for (int i = 0; i < phone_book.length; i++) {
                temp = phone_book[i];

                for (int j = 0; j < phone_book.length; j++) {
                    if (i == j) continue;

                    if (phone_book[j].startsWith(temp)) {
                        return false;
                    }
                }
            }
            return true;


            /*
            -정렬 풀이법
            -어떤 번호 A가 접두어라면 그 번호로 시작하는 애들은 정렬했을 때 바로 뒤에 몰림
            Arrays.sort(phone_book);

            for (int i = 0; i < phone_book.length - 1; i++) {
                if (phone_book[i + 1].startsWith(phone_book[i])) {
                    return false;
                }
            }

            return true;


            -해시맵 풀이법
             Map<String, Boolean> map = new HashMap<>();

            // 1. 모든 전화번호 저장
            for (String phone : phone_book) {
                map.put(phone, true);
            }

            // 2. 각 전화번호의 접두어가 map에 있는지 확인
            for (String phone : phone_book) {
                for (int i = 1; i < phone.length(); i++) {
                    String prefix = phone.substring(0, i);

                    if (map.containsKey(prefix)) {
                        return false;
                    }
                }
            }

            return true;
        }
     */
        }
    }
}
