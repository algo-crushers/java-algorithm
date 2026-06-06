package greedy.makelargenumber;

import java.util.*;

public class JeongHaewon {

    public static void main(String[] args) {
        JeongHaewon hw = new JeongHaewon();
        String[] number = {"1924", "1231234", "4177252841", "4321"};
        int k[] = {2, 3, 4, 2};
        for (int i = 0; i < number.length; i++) {
            System.out.println(hw.solution(number[i], k[i]));
        }
    }

    public String solution(String number, int k) {
        Deque<Character> dq = new ArrayDeque<>();

        for (int i = 0; i < number.length(); i++) {
            char cur = number.charAt(i);
            while (!dq.isEmpty() && cur > dq.getLast() && k > 0) {
                dq.removeLast();
                k--;
            }
            dq.addLast(cur);
        }

        while(k>0){ //"4321"일때 남은 k를 결과 길이에서 처리
            dq.removeLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : dq) {
            sb.append(c);
        }
        return sb.toString();
    }

}
