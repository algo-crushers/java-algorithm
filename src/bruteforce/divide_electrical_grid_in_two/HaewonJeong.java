package bruteforce.divide_electrical_grid_in_two;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class HaewonJeong {

    public static void main(String[] args) {

        HaewonJeong hw = new HaewonJeong();
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        System.out.println(hw.solution(9, wires));
    } //1,3 2,3 3,4 4,5 6,7

    public int solution(int n, int[][] wires) {
        int resVal = Integer.MAX_VALUE;

        for (int i = 0; i < wires.length; i++) {
            //System.out.println("i" + i);
            int[] leftArr = new int[n + 1];
            int[] rightArr = new int[n + 1];

            int left = wires[i][0];  //i가 2일때, left =3, right =4
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

                //끊어낸 전선은 패스!
                if (wire[0] == left && wire[1] == right) {
                    continue;
                }

                //왼쪽팀(leftArr)에 연결 되어있는지 확인
                if (leftArr[wire[0]] == 1 || leftArr[wire[1]] == 1) {
                    leftArr[wire[0]] = 1;
                    leftArr[wire[1]] = 1;
                    consumed0 = true;
                }

                //오른쪽팀(rightArr)에 연결되어있는지 확인
                if (rightArr[wire[0]] == 1 || rightArr[wire[1]] == 1) {
                    rightArr[wire[0]] = 1;
                    rightArr[wire[1]] = 1;
                    consumed1 = true;
                }

                //왼쪽이든 오른쪽이든 '한 곳이라도' 연결됐다면?
                if (consumed0 || consumed1) {
                    continue; // 큐에 다시 넣지 않고 여기서 끝내기 (큐에서 제거 완료!)
                }
                // 두 팀 모두에게 버림받은 낙동강 오리알 전선만 다시 큐의 뒤로 보내기!
                q.offer(wire);
            }

            int leftFamily = Arrays.stream(leftArr)
                    .filter(num -> num == 1)
                    .reduce(0, Integer::sum);

            int rightFamily = Arrays.stream(rightArr)
                    .filter(num -> num == 1)
                    .reduce(0, Integer::sum);

            resVal = Math.min(resVal, Math.abs(leftFamily - rightFamily));
            //System.out.println(" leftFamily/rightFamily: "+leftFamily+"/"+rightFamily);
            //System.out.println(" resVal: "+resVal);

        }
        return resVal;
    }

}

/*
[답]
i=2 일때 최소값
leftFamily/rightFamily: 3/6
resVal: 3
* */