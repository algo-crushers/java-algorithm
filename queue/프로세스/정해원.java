/*스택/큐 - 프로세스*/
/*현재 일부 테스트 실패*/
import java.util.*;

public class 정해원 {
    public static void main(String[] args){
        Solution sol = new Solution();

        int[] priorities = new int[]{1, 1, 9, 1, 1, 1};
        int location = 0;

        int answer = sol.solution(priorities, location);
        System.out.println(answer);
    }
}

class Solution {
    public int solution(int[] priorities, int location){
        Deque<Character> deque = new ArrayDeque<>(); // 배열 기반으로 만든 Deque (속도가 빠름)
        char a = 65;
        for(int t = 0; t<priorities.length; t++){
            //System.out.print(a);
            deque.addLast(a);
            a++;
        }
        //System.out.println("");
        for(int i=0; i<priorities.length; i++){
            int current = priorities[i]; //2
            //System.out.println("current"+current);
            int flag = 0;
            for(int j=i+1; j<priorities.length; j++){
                //System.out.println("priorities[j]"+priorities[j]);
                if(current < priorities[j]){
                    flag = 1; //큰값 있음
                    break;
                }
                else{
                    flag = -1; //큰값 없음
                }
            }
            //System.out.println("flag"+flag);
            if(flag == 1){ //큰값이 있으면 첫번째 항목을 맨 뒤에 넣는다.
                deque.addLast(deque.peekFirst());
                deque.removeFirst();
            }
            else if (flag == -1){
                //deque.peek();
            }
        }
        System.out.print("sol: ");
        int size = deque.size();
        int answer = 0;
        for(int b=1; b <= size;b++){
            //System.out.print("size: "+size);
            if(location+65 == deque.peekFirst() ){
                answer = b;
                //System.out.print("deque.peekFirst():"+deque.peekFirst());
            }
            System.out.print(deque.peekFirst()+",");
            deque.removeFirst();
        }
        //System.out.print("answer:"+answer);
            return answer;
        }
}
