package greedy.makelargenumber;

import java.util.*;

public class HanDaHyun {
    public static void main(String[] args) {
        HanDaHyun dh = new HanDaHyun();
        String number1 = "1924";
        String number2 = "1231234";
        String number3 = "4177252841";

        int k1 = 2;
        int k2 = 3;
        int k3 = 4;

        System.out.println(dh.solution(number1, k1));
        System.out.println(dh.solution(number2, k2));
        System.out.println(dh.solution(number3, k3));
    }

    public String solution(String number, int k) {
        Deque<Character> dq = new ArrayDeque<>();

        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);

            while (!dq.isEmpty() && k > 0 && dq.peekLast() < current) {
                dq.pollLast();
                k--;
            }

            dq.addLast(current);
        }

        while (k > 0) {
            dq.pollLast();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : dq) {
            sb.append(c);
        }

        return sb.toString();
    }
}
