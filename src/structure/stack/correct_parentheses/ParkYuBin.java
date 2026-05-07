package structure.stack.correct_parentheses;

import java.util.Stack;

public class ParkYuBin {
    public static void main(String[] args) {
        ParkYuBin yb = new ParkYuBin();

        String s1 = "()()";
        String s2 = "(())()";
        String s3 = ")()(";
        String s4 = "(()(";

        System.out.println(yb.solution(s1));
        System.out.println(yb.solution(s2));
        System.out.println(yb.solution(s3));
        System.out.println(yb.solution(s4));
    }

    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
