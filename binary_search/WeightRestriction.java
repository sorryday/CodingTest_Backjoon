package binary_search;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class WeightRestriction {
    static int N; // 섬의 개수
    static int M; // 다리의 개수

    static class Node {
        int v;
        long cost;

        public Node(int v, long cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static List<Node>[] inList; // 인접 리스트
    static long result = Integer.MIN_VALUE;

    static int start, end;
    static long min = Integer.MAX_VALUE; // 주어진 간선 중 최솟값
    static long max = Integer.MIN_VALUE; // 주어진 간선 중 최대 값

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력을 받아 변수 초기화 및 인접리스트 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            inList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            inList[from].add(new Node(to, cost));
            inList[to].add(new Node(from, cost));

            // 간선의 최대값 구하기
            min = Long.min(min, cost);
            max = Long.max(max, cost);
        }

        // 출발 노드 번호 및 도착 노드 번호
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        // 이분탐색 함수 시작
        weightRestrictionBinarySearch();

        //결과 출력
        bw.write(Long.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    // 이분 탐색 함수 : 이분탐색의 주체는 간선의 비용
    private static void weightRestrictionBinarySearch() {
        long left = min;
        long right = max;

        // weightRestrictionBFS의 리턴 값은 true or false
        // 만약 true가 리턴 됬다는 것은 도착지점에 도착했다는 것이므로 result를 갱신
        while (left <= right) {
            long mid = (left + right) / 2;

            if (weightRestrictionBFS(mid)) {
                result = Long.max(result, mid);

                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    // bfs 함수
    private static boolean weightRestrictionBFS(long mid) {
        // 방문 배열
        visited = new boolean[N + 1];

        // BFS를 위한 큐
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(start, mid));
        visited[start] = true;

        while (!q.isEmpty()) {
            Node poll = q.poll();

            // 두번째 공장에 도착했다면
            if (poll.v == end) {
                return true;
            }

            for (int i = 0; i < inList[poll.v].size(); i++) {
                // 연결된 노드가 null이 아니고 방문 처리하지 않았고
                if (inList[poll.v].get(i) != null && !visited[inList[poll.v].get(i).v]
                        && mid <= inList[poll.v].get(i).cost) {
                    visited[inList[poll.v].get(i).v] = true;
                    q.add(new Node(inList[poll.v].get(i).v, mid));
                }
            }
        }
        return false;
    }
}