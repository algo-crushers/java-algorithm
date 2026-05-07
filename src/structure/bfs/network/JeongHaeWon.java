package structure.bfs.network;
import java.util.LinkedList;
import java.util.Queue;
/*푸는중!*/

public class JeongHaeWon {
    public static void main(String[] args) {

        JeongHaeWon hw = new JeongHaeWon();
        int n = 3;
        int[][] computers = {{1,1,0}, {1,1,1},{0,1,1}};
        int sol = hw.solution(n,computers);
        System.out.println(sol);
    }
    public int solution(int n, int[][] computers) {
        Queue< int[] > qu = new LinkedList();

        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n ; j++){
                if( !(i==j) && computers[i][j] == 1){ //[1,1], [2,2], [3,3] 제외
                    qu.add( new int[]{i+1,j+1} );
                }
            }
        }

        while(!qu.isEmpty()){
            int edge[] = qu.poll();
            System.out.println(edge[0]+", "+edge[1]+" 연결됨");

            //작성중...
            //어떻게 풀까
            //[1,2], [2,1], [2,3], [3,2] 들어감
            //[1,2] -> [2,3] 면 연결됨
            //[1,2]에서 2를 어딘가에 저장?
            //자기자신이 아닌 다른 노드로 이어지는 배열 찾음? [2,3]
            // 어딘가에 [1,2] [2,3] 결과 나옴?? => 답 2??

        }

        int answer = 0;
        return answer;
    }


}
