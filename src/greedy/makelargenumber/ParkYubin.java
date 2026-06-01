package greedy.makelargenumber;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;
import java.util.stream.Collectors;

public class ParkYubin {
    public static void main(String[] args) {
        ParkYubin yb = new ParkYubin();
        System.out.println(yb.solution("1924", 2));
        System.out.println(yb.solution("1231234", 3));
        System.out.println(yb.solution("4177252841", 4));
    }

    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
