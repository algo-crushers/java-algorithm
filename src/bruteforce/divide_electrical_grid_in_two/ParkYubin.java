package bruteforce.divide_electrical_grid_in_two;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ParkYubin {
    public static void main(String[] args) {
        ParkYubin yb = new ParkYubin();
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        System.out.println(yb.solution(9, wires));
    }

    public int solution(int n, int[][] wires) {
        int resVal = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            int[] leftArr = new int[n+1];
            int[] rightArr = new int[n+1];

            int left = wires[i][0];
            int right = wires[i][1];

            leftArr[left] = 1;
            rightArr[right] = 1;

            Deque<int[]> q = new ArrayDeque<>();
            for (int[] wire : wires) {
                q.offer(wire);
            }

            while (!q.isEmpty()) {
                int[] wire = q.poll();
                boolean consumed0 = false;
                boolean consumed1 = false;

                if (wire[0] == left && wire[1] == right) {
                    continue;
                }

                if (leftArr[wire[0]] == 1) {
                    leftArr[wire[1]] = 1;
                    consumed0 = true;
                }

                if (leftArr[wire[1]] == 1) {
                    leftArr[wire[0]] = 1;
                    consumed1 = true;
                }

                if (rightArr[wire[0]] == 1) {
                    rightArr[wire[1]] = 1;
                    consumed0 = true;
                }

                if (rightArr[wire[1]] == 1) {
                    rightArr[wire[0]] = 1;
                    consumed1 = true;
                }

                if (consumed0 && consumed1) {
                    continue;
                }

                q.offer(wire);
            }

            int leftFamily = Arrays.stream(leftArr)
                    .filter(num -> num == 1)
                    .reduce(0, Integer::sum);

            int rightFamily = Arrays.stream(rightArr)
                    .filter(num -> num == 1)
                    .reduce(0, Integer::sum);

            resVal = Math.min(resVal, Math.abs(leftFamily - rightFamily));

        }

        return resVal;
    }
}
