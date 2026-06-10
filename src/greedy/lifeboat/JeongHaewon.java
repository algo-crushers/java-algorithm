package greedy.lifeboat;

import java.util.Arrays;

public class JeongHaewon {

    public static void main(String[] args) {

        JeongHaewon hw = new JeongHaewon();
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println(hw.Solution(people, limit));

    }

    public int Solution(int[] people, int limit)
    {
        int answer = 0;

        Arrays.sort(people);

        int min = 0;
        for(int max = people.length-1; min <= max ; max--){
            if(people[min] + people[max] <= limit) min++;
            answer++;
        }

        return answer;
    }
}
