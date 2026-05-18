package structure.heap.disk_controller;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HaewonJeong {

    public static void main(String[] args) {
        HaewonJeong hw = new HaewonJeong();
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}}; //{요청시각, 작업 종료시각}
        System.out.println(hw.solution(jobs));
    }
    public int solution(int[][] jobs){
        int answer = 0;
        int time = 0;
        int idx = 0;
        int len = jobs.length;

        //작업의 소요시간 오름차순 정렬
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        //작업 요청시점 오름차순 정렬
        Arrays.sort(jobs, new Comparator<int[] >() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[0] - o2[0];
                    }
        });

        while(!pq.isEmpty() || idx < len){
            //현재 시간 보다 작거나 같은 요청시점을 큐에 추가
            //즉 pq에는 "현재 시각에 도착한 작업들"만 들어감
            while(idx < len && jobs[idx][0] <= time){
                pq.offer(jobs[idx++]);
            }
            //1. 큐에 작업이 없다면
            if(pq.isEmpty()){
                //작업 요청시점이 가장 빠른 작업 추가
                //즉 CPU가 할 일이 없는 상태 ex)time=3인데
                //다음 작업 요청시간 10이 들어오면 time을 10으로 이동 시킨다.
                time = jobs[idx][0];
            }
            //2. 큐에 작업이 있다면
            else{
                //대기 큐에서 작업 소요시간이 가장 짧은 작업을 꺼내서 작업을 시킴
                //(작업 완료 시각 - 요청 시각)을 answer에 누적 한다.
                int[] job = pq.poll();
                time += job[1];
                answer += time - job[0];
            }
        }
        return answer / len;
    }
}