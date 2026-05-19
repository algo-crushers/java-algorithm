package structure.sorting.hIndex;
import java.util.Arrays;

public class JeongHaeWon {
    public static void main(String[] args) {

        JeongHaeWon hw = new JeongHaeWon();
        int[] citations = { 3,0,6,15 };
        System.out.println( hw.Solution(citations) );

    }
    /*통과 코드*/
    public int Solution(int[] citations){

        int answer = 0; //결과를 저장할 변수 초기화
        Arrays.sort(citations); //논문 인용 횟수를 오름차순으로 정렬
        int size = citations.length; //배열의 길이 저장

        for(int i = 0; i < size-1 ; i++){
            //현재 검사하는 논문의 인용 횟수가 남은 논문 수 (size-i)보다 크거나 같다면,
            // 해당 논문을 기준으로 H-Index를 계산 할 수 있음
           int citedPaper = size - i; //인용된 논문의 수

            if( (citations[i] >= citedPaper)){
                answer = citedPaper; //H-Index를 현재 논문의 인용 횟수로 설정
                break; //최대값을 구하므로 조건을 만족하는 경우 반복문 종료
            }
        }
        return answer; //최종 H-Index 반환
    }
}

/*초기 코드
합계: 6.3 / 100.0*/
/*public int Solution(int[] citations){
        //정렬...
        //3번이상 인용된 논문이 3편이상이고, 나머지 논문이 h번이하 인용
        int answer = 0;
        ArrayList<Integer> hindexs = new ArrayList<>();
        for(int i = 0; i < citations.length; i++){
            //System.out.println("==i"+i);
            int h = citations[i];
            int habove = 0;
            int hbelow = 0;
            for(int j =0; j < citations.length; j++){
                //System.out.println("==j"+j);
                //h번 이상 인용된 논문이
                if( h <= citations[j]){
                    habove++;
                }else {
                    hbelow++;
                }
                //System.out.println("habove:"+habove);
               // System.out.println("hbelow:"+hbelow);
            }
            if ( (habove >= h) && (h > hbelow)){
                hindexs.add(h);
                //System.out.println("h:"+h);
            }
        }

        //System.out.println(hindexs.get(0));

        //Arraylist 내림차순 정렬
        Collections.sort(hindexs, Collections.reverseOrder());
        answer = hindexs.get(0);
        return answer;
    }
* */
