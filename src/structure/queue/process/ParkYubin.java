package structure.queue.process;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class ParkYubin {
    public static void main(String[] args) {
        ParkYubin sol = new ParkYubin();

        int[] priorities = new int[]{1, 1, 9, 1, 1, 1};
        int location = 0;

        int[] priorities2 = new int[]{2, 1, 3, 2};
        int location2 = 2;

        System.out.println(sol.solution(priorities, location));
        System.out.println(sol.solution(priorities2, location2));
    }

    public int solution(int[] priorities, int location) {
        Deque<List<Integer>> queue = new ArrayDeque<>();
        Deque<Integer> order = new ArrayDeque<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(List.of(priorities[i], i));
            order.add(priorities[i]);
        }

        List<Integer> current = new ArrayList<>(order);
        current.sort(Collections.reverseOrder());
        order = new ArrayDeque<>(current);

        int max = order.peek();

        int idx = 0;
        while (!queue.isEmpty()) {
            List<Integer> now = queue.poll();
            int priority = now.get(0);
            int index = now.get(1);

            if (priority == max) {
                order.poll();

                if (order.isEmpty()) {
                    return priorities.length;
                }

                max = order.peek();

                if (index == location) {
                    return idx+1;
                }

                idx += 1;

            } else {
                queue.add(now);

            }
        }
        return priorities.length;
    }
}
