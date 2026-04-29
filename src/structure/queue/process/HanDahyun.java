package structure.queue.process;

import java.util.*;

public class HanDahyun {
    public static void main(String[] args) {
        HanDahyun dh = new HanDahyun();
        int sol1 = dh.solution(new int[]{2, 1, 3, 2}, 2);
        int sol2 = dh.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);

        System.out.println(sol1);
        System.out.println(sol2);
    }

    public int solution(int[] priorities, int location) {
        Deque<Integer> pDeque = new ArrayDeque<>();
        Deque<Integer> lDeque = new ArrayDeque<>();

        int size = priorities.length;
        for (int i = 0; i < size; i++) {
            pDeque.add(priorities[i]);
            lDeque.add(i);
        }

        int result = 0;
        while(!pDeque.isEmpty()) {
            int currentPriority = pDeque.poll();
            int currentLocation = lDeque.poll();

            int max = pDeque.isEmpty()
                    ? currentPriority
                    : Math.max(currentPriority, Collections.max(pDeque));

            //if (pDeque.stream().anyMatch(x -> x > currentPriority))
            if (currentPriority < max) {
                pDeque.add((currentPriority));
                lDeque.add(currentLocation);
            } else {
                result++;

                if (currentLocation == location) {
                    return result;
                }
            }
        }
        return result;
    }
}
