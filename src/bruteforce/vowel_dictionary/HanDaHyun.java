package bruteforce.vowel_dictionary;

import java.util.ArrayList;
import java.util.List;

public class HanDaHyun {

    static String[] vowels = {"A", "E", "I", "O", "U"};
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        HanDaHyun dh = new HanDaHyun();
        String word1 = "AAAAE";
        String word2 = "AAAE";

        System.out.println(dh.solution(word1));
        System.out.println(dh.solution(word2));
    }

    public int solution(String word) {
        dfs("");

        return list.indexOf(word) + 1;
    }

    static void dfs(String current) {
        if (current.length() == 5) return;

        for (String vowel : vowels) {
            String next = current + vowel;
            list.add(next);
            dfs(next);
        }
    }
}