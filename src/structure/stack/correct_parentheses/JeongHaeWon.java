package structure.stack.correct_parentheses;
import java.util.Stack;

public class JeongHaeWon {
    public static void main(String[] args) {
        JeongHaeWon hw = new JeongHaeWon();
        boolean sol = hw.solution(")()(");
        System.out.println(sol);
    }

    public boolean solution(String s) {
        boolean answer = true;

        Stack<Character> sk = new Stack<>();
        char[] ch_arr = s.toCharArray();
        System.out.println(ch_arr);

        for(int i = 0 ; i<ch_arr.length; i++){
            System.out.println(i);
            //")()(" 예외처리
            if(ch_arr[0] == ')'){
                answer = false;
                break;
            }
            //'('이면 sk에 넣고
            if(ch_arr[i] == '('){
                sk.push( ch_arr[i] );
            }
            else if (ch_arr[i] == ')'){
                sk.pop();
            }
        }

        if(!sk.isEmpty()){
            answer = false;
        }

        return answer;
    }
}