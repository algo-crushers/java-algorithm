package sorting.largest_number;
import java.util.Arrays;
import java.util.Comparator;

public class JeongHaeWon {
    public static void main(String[] args) {

        JeongHaeWon hw = new JeongHaeWon();
        int[] numbers = {6,10,2};
        String  sol = hw.solution(numbers);
        System.out.println(sol);

    }

    public String solution(  int[] numbers ) {

        StringBuilder answer = new StringBuilder();
        String[] arr = new String[numbers.length];

        //1. 숫자를 문자열로 만듦
        for(int i = 0; i<numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }

        //2. 내림차순 정렬
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });

        //3. 맨 앞자리가 0인 경우
        if(arr[0].equals("0")){
            return "0";
        }

        //4. 배열을 문자열로 변환
        for(int j = 0; j <arr.length; j++){
            answer.append(arr[j]);
        }
        return answer.toString();
    }
}


/*
*
        // 1. 숫자 정렬
        int[] arr = {5, 3, 1, 4, 2};
        Arrays.sort(arr); // 오름차순: [1, 2, 3, 4, 5]

        // 2. 내림차순 정렬 (Integer 사용)
        Integer[] arr2 = {5, 3, 1, 4, 2};
        Arrays.sort(arr2, Collections.reverseOrder()); // [5, 4, 3, 2, 1]
        int : 기본 자료형 (primitive type)
        Integer : int를 객체로 감싼 클래스 (wrapper class)
        숫자를 객체로 저장
        null도 저장 가능
        Collections 기능 사용 가능
        Collections.reverseOrder()는 객체 타입(Integer) 에만 적용됩니다.

        // 3. 객체 정렬 (Comparator)
        List<Person> people = new ArrayList<>();
        people.sort(Comparator.comparing(Person::getAge)); // 나이순 정렬

        * 시간복잡도
        * Arrays.sort()	평균 : O(nlogn) / 최악 : O(n^2)
        * Collections.sort()	O(nlogn)

        * */
