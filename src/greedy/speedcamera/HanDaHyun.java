package greedy.speedcamera;

import java.util.Arrays;

public class HanDaHyun {
    public static void main(String[] args) {
        HanDaHyun dh = new HanDaHyun();
        int[][] arr = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
        System.out.println(dh.solution(arr));
    }

    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        int camera = 1;
        int lastCamera = routes[0][1];

        for (int i = 0; i < routes.length; i++) {
            if (routes[i][0] > lastCamera) {
                camera++;
                lastCamera = routes[i][1];
            }
        }
        return camera;
    }
}