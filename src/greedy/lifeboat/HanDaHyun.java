package greedy.lifeboat;

import java.util.Arrays;

public class HanDaHyun {
    public static void main(String[] args) {
        HanDaHyun dh = new HanDaHyun();
        int[] people1 = {70, 50, 80, 50};
        int[] people2 = {70, 80, 50};

        int limit = 100;

        System.out.println(dh.solution(people1, limit));
        System.out.println(dh.solution(people2, limit));
    }

    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int boats = 0;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            boats++;
        }


        return boats;
    }
}
