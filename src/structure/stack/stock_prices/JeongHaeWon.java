package structure.stack.stock_prices;
import java.util.Stack;

public class JeongHaeWon {
    public static void main(String[] args) {
        JeongHaeWon hw = new JeongHaeWon();

        int[] prices = {1, 2, 3, 2, 3};
        //return [4, 3, 1, 1, 0]
        int[] sol = hw.solution(prices);
        for (int s : sol){
            System.out.print(s);
        }
    }

    public int[] solution(int[] prices){
        int[] answer = new int[prices.length];
        Stack<Integer> sk = new Stack<>();

        for(int i = 0; i < prices.length; i++){

            while( !sk.isEmpty() && prices[ sk.peek() ] > prices[i] ){
                answer[sk.peek()] = i - sk.peek();
                sk.pop();
            }
            sk.push(i);
        }
        while(!sk.isEmpty()){
         answer[sk.peek()] = prices.length - sk.peek() - 1;
         sk.pop();
        }
        return answer;
    }
}
/*
왼쪽부터 오른쪽으로 순회하며,
“하락 시점”이 발생하면 그 순간을 기준으로 이전 가격들의 유지 시간을 확정한다.
이때 스택에는 아직 하락하지 않은 과거 가격의 인덱스가 저장된다.
* */
