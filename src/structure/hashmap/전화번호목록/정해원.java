/*전화번호 목록*/
import java.util.HashMap;

public class 정해원 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        String[] number = {
                "119", "97674223", "1195524421"
        };

        System.out.println(sol.solution(number));
    }
}

class Solution {
    public boolean solution(String[] numbers) {
        HashMap<String, Integer> numbersMap = new HashMap<>();

        for(int i = 0; i < numbers.length; i++){
            //numbers[0] = "119"
            numbersMap.put(numbers[i], i);
        }

        for(int i = 0; i < numbers.length; i++){
            for (int j = 0; j < numbers[i].length(); j++) {
                //System.out.println("i:"+i+"j:"+j+"/numbers[i]:"+numbers[i]);
                if (numbersMap.containsKey(numbers[i].substring(0, j))) {
                    //System.out.println("i:"+i+"j:"+j+"/substring:"+numbers[i].substring(0, j));
                    return false;
                }
            }
        }
        return true;
    }
}

/*
* substring(int beginIndex, int endIndex)는 시작 인덱스부터 종료 인덱스 '전'까지의 문자열을 반환 => 자기자신 체크하지 않음
* */
