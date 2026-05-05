package structure.stack.correct_parentheses;

import java.util.*;

public class HanDaHyun {
    public static void main(String[] args) {
        HanDaHyun dh = new HanDaHyun();

        String s1 = "()()";
        String s2 = "(())()";
        String s3 = ")()(";
        String s4 = "(()(";

        System.out.println(dh.solution(s1));
        System.out.println(dh.solution(s2));
        System.out.println(dh.solution(s3));
        System.out.println(dh.solution(s4));
    }

    boolean solution(String s) {
        Deque<Character> dq = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (dq.isEmpty() && c == ')') {
                return false;
            }

            if (c == '(') {
                dq.addLast(c);
            } else {
                dq.poll();
            }
        }
        return dq.isEmpty();
    }
}
