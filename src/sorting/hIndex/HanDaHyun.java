package sorting.hIndex;

import java.util.Arrays;

public class HanDaHyun {
    public static void main(String[] args) {
        HanDaHyun dh = new HanDaHyun();
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(dh.solution(citations));
    }

    public int solution(int[] citations) {
        Arrays.sort(citations);
        int size = citations.length;

        for (int i = 0; i < size; i++) {

            if (citations[i] >= size - i) {
                return size - i;
            }
        }
        return 0;
    }
}