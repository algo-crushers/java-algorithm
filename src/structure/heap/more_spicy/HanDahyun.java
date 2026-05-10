package structure.heap.more_spicy;

import java.util.PriorityQueue;

public class HanDahyun {
    public static void main(String[] args) {
        HanDahyun dh = new HanDahyun();

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(dh.solution(scoville, K));
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : scoville) {
            pq.offer(i);
        }

        int count = 0;
        while (pq.size() >= 2 && pq.peek() < K) {
            int first = pq.poll();
            int second = pq.poll();
            int mixed = first + (second * 2);
            count++;
            pq.offer(mixed);
        }

        if (!pq.isEmpty() && pq.peek() < K) {
            return -1;
        }

        return count;
    }
}
