package bruteforce.vowel_dictionary;

import java.util.ArrayList;

public class ParkYubin {

    public static void main(String[] args) {
        ParkYubin yb = new ParkYubin();
        System.out.println(yb.solution("AAAAE"));
        System.out.println(yb.solution("AAAE"));
        System.out.println(yb.solution("I"));
        System.out.println(yb.solution("EIO"));
    }

    public static ArrayList<String> al = new ArrayList<>();

    public int solution(String word) {
        dfs(new StringBuilder());
        return al.indexOf(word) + 1;
    }

    public void dfs(StringBuilder current) {
        if (current.length() == 5) {
            return;
        }

        for (char v : "AEIOU".toCharArray()) {
            current.append(v);
            al.add(current.toString());
            dfs(current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
