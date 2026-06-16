package dp.n_expression;

import java.util.HashSet;
import java.util.Set;

public class HanDaHyun {
    public static void main(String[] args) {
        HanDaHyun dh = new HanDaHyun();
        int N1 = 5;
        int number1 = 12;
        int N2 = 2;
        int number2 = 11;

        System.out.println(dh.solution(N1, number1));
        System.out.println(dh.solution(N2, number2));
    }

    public int solution(int N, int number) {
        Set<Integer>[] dp = new HashSet[9];
        for (int i = 0; i < 9; i++) dp[i] = new HashSet<>();

        for (int i = 1; i <= 8; i++) {
            // N을 i번 이어붙인 수
            int concat = Integer.parseInt(String.valueOf(N).repeat(i));
            dp[i].add(concat);

            for (int j = 1; j < i; j++) {
                for (int a : dp[j]) {
                    for (int b : dp[i - j]) {
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        if (b != 0) dp[i].add(a / b);
                    }
                }
            }
            if (dp[i].contains(number)) return i;
        }
        return -1;
    }
}