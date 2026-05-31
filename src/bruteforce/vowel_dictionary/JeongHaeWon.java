package bruteforce.vowel_dictionary;

import java.util.ArrayList;

public class JeongHaeWon {


    static String[] vowels = {"A", "E", "I", "O", "U"};
    static ArrayList<String> al = new ArrayList<>();

    public static void main(String[] args) {

        JeongHaeWon hw = new JeongHaeWon();
        String word1 = "A";
        String word2 = "AAAE";
        String word3 = "I";
        String word4 = "EIO";

        System.out.println(hw.solution(word1));
        System.out.println(hw.solution(word2));
        System.out.println(hw.solution(word3));
        System.out.println(hw.solution(word4));

    }

    public int solution(String word) {

        dfs("");

        return al.indexOf(word) + 1;

    }

    static void dfs(String next) {

        if (next.length() == 5) {
            return;
        }

        for (String v : vowels) {
            String current = next + v;
            al.add(current);
            dfs(current);
        }
    }
}
