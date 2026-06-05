package bruteforce.VowelDictionary;

import java.util.ArrayList;
import java.util.List;

public class HanDaHyun {
    static String[] vowels = {"A", "E", "I", "O", "U"};
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        HanDaHyun dh = new HanDaHyun();
        String word1 = "AAAAE";
        String word2 = "AAAE";
        String word3 = "I";
        String word4 = "EIO";

        System.out.println(dh.solution(word1));
        System.out.println(dh.solution(word2));
        System.out.println(dh.solution(word3));
        System.out.println(dh.solution(word4));
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
