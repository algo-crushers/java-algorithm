package structure.stack.stock_prices;

import java.util.Arrays;
import java.util.Stack;

public class ParkYuBin {
    public static void main(String[] args) {
        ParkYuBin yb = new ParkYuBin();
        System.out.println(Arrays.toString(yb.solution(new int[]{1, 2, 3, 2, 3})));
    }

    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && prices[st.peek()] > prices[i]) {
                int idx = st.pop();
                res[idx] = i - idx;
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            int idx = st.pop();
            res[idx] = n - idx - 1;
        }

        return res;
    }
}
