package structure.stack.correct_parentheses;

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
        boolean answer = true;

        return answer;
    }
}
