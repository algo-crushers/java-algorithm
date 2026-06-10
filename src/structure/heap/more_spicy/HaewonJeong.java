package structure.heap.more_spicy;
import java.util.PriorityQueue;

public class HaewonJeong {

    public static void main(String[] args) {
        HaewonJeong hw = new HaewonJeong();
        int[] scoville  = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(hw.solution(scoville, K));
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;
        for(int i=0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }

        while(true){
            if(pq.size() <= 1){
                return -1;
            }
            if(pq.peek() >= K){
                return count;
            }

            int first = pq.poll();
            int second = pq.poll();

                pq.offer(first + second*2);
                count++;
        }

    }
}
