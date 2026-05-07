package bfs.network;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParkYubin {
    public static void main(String[] args) {
        ParkYubin yb = new ParkYubin();
        int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(yb.solution(3, computers1));

        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(yb.solution(3, computers2));
    }

    private void bfs(int start, boolean[] visited, List<List<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }

    public int solution(int n, int[][] computers) {
        // 1. 방문 확인을 위한 배열 (0번부터 n-1번까지 사용)
        boolean[] visited = new boolean[n];
        int cnt = 0;

        // 2. 인접 리스트(graph) 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        // 3. 모든 노드를 순회하며 방문하지 않은 곳은 BFS 시작
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, visited, graph);
                cnt++; // BFS가 호출된 횟수가 곧 네트워크(연결 요소)의 개수
            }
        }

        return cnt;
    }
}
