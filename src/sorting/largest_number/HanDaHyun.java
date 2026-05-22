package sorting.largest_number;

import java.util.Arrays;

public class HanDaHyun {
    public static void main(String[] args) {
        HanDaHyun dh = new HanDaHyun();
        int[] numbers1 = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};
        System.out.println(dh.solution(numbers1));
        System.out.println(dh.solution(numbers2));
    }

    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();

        String[] arr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        if (arr[0].equals("0")) {
            return "0";
        }

        for (String s : arr) {
            sb.append(s);
        }

        return sb.toString();
    }
}