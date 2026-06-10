package dp.thievery;

public class ParkYubin {
    public static void main(String[] args) {
        ParkYubin instance = new ParkYubin();
        int[] money1 = {1, 2, 3, 1};
        System.out.println(instance.solution(money1));
    }

    public int solution(int[] money) {
        int n = money.length;

        int caseA = rob(money, 0, n - 2);
        int caseB = rob(money, 1, n - 1);

        return Math.max(caseA, caseB);
    }

    private int rob(int[] money, int start, int end) {
        int len = end - start + 1;
        if (len == 1) return money[start];

        int[] dp = new int[len];

        dp[0] = money[start];
        dp[1] = Math.max(money[start], money[start + 1]);

        for (int i = 2; i < len; i++) {
            int idx = start + i;
            dp[i] = Math.max(
                    dp[i - 1],
                    dp[i - 2] + money[idx]
            );
        }

        return dp[len - 1];
    }
}
