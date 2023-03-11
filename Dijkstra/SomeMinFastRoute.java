package Dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SomeMinFastRoute {
    static int N; // 정점의 개수
    static int E; // 간선의 개수
    static int[] D; // 최솟값을 저장할 배열
    static boolean[] visited; // 방문 배열
    static class Node {
        int myV;        // 내 정점 번호
        int cost;

        public Node(int v, int cost) {
            this.myV = v;
            this.cost = cost;
        }
    }

    static List<Node>[] nodeList; // 인접리스트

    static int resultFirst = 0;
    static int resultSecond = 0;

    static int first, second; // 꼭 방문해야 하는 정점들
    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 인접 리스트 초기화
        nodeList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            nodeList[i] = new ArrayList<>();
        }

        // 인접리스트 연결
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            nodeList[from].add(new Node(to, cost));
            nodeList[to].add(new Node(from, cost));
        }

        // 꼭 방문해야 하는 정점
        st = new StringTokenizer(br.readLine());
        first = Integer.parseInt(st.nextToken());
        second = Integer.parseInt(st.nextToken());

        // 첫 번째 다익스트라
        sendDij(1, first, true);
        sendDij(first, second, true);
        sendDij(second, N, true);

        // 두 번째
        sendDij(1, second, false);
        sendDij(second, first, false);
        sendDij(first, N, false);

        //결과 출력
        if (resultFirst >= Integer.MAX_VALUE && resultSecond >= Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(Integer.toString(Math.min(resultFirst, resultSecond)));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    // 다익스트라 전달 함수
    private static void sendDij(int start, int end, boolean flag) throws IOException {
        // D배열, 방문 배열 초기화
        D = new int[N + 1];
        visited = new boolean[N + 1];
        Arrays.fill(D, Integer.MAX_VALUE);

        // start와 end가 같다면
        if (start == end) {
            return;
        } else {
            int t = minCostDij(start, end);

            if (flag) {
                resultFirst += t;
            } else {
                resultSecond += t;
            }
        }
    }

    // 다익스트라 함수
    private static int minCostDij(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.cost - o2.cost;
            }
        });

        // 시작 노드를 넣기
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (!visited[node.myV]) {
                visited[node.myV] = true;
            }

            // 내 인접 노드를 확인
            for (int i = 0; i < nodeList[node.myV].size(); i++) {
                Node next = nodeList[node.myV].get(i);
                if (next != null) {
                    if (D[next.myV] > node.cost + next.cost) {
                        D[next.myV] = node.cost + next.cost;
                        pq.add(new Node(next.myV, D[next.myV]));
                    }
                }
            }
        }
        return D[end];
    }
}