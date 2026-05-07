package structure.heap.more_spicy;

import java.util.PriorityQueue;

public class ParkYuBin {
    public static void main(String[] args) {
        ParkYuBin yb = new ParkYuBin();
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(yb.solution(scoville, K));
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }

        int count = 0;
        while (pq.peek() < K) {
            if (pq.size() == 1) {
                return -1;
            }

            int first = pq.poll();
            int second = pq.poll();
            pq.offer(first + second * 2);
            count++;
        }

        return count;
    }
}
