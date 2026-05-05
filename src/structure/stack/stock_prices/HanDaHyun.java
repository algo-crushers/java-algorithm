package structure.stack.stock_prices;

import java.util.*;

public class HanDaHyun {
    public static void main(String[] args) {
        HanDaHyun dh = new HanDaHyun();

        int[] prices = {1, 2, 3, 2, 3};

        System.out.println(Arrays.toString(dh.solution(prices)));
    }

    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];

        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < prices.length; i++) {
            while (!dq.isEmpty() && prices[dq.peekLast()] > prices[i]) {
                int index = dq.pollLast();
                result[index] = i - index;
            }
            dq.addLast(i);
        }

        while (!dq.isEmpty()) {
            int index = dq.pollLast();
            result[index] = prices.length - 1 - index;
        }

        return result;
    }
}
