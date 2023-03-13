package Dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ShortestPath {

    static class Node {
        int nV;
        int nCost;

        public Node(int nV, int nCost) {
            this.nV = nV;
            this.nCost = nCost;
        }
    }

    static List<Node>[] inList; // 인접 리스트
    static int V; // 총 정점의 개수
    static int E; // 총 간선의 개수
    static int startV; // 스타트 정점
    static int[] D; // 최소 비용이 저장된 배열
    static boolean[] visited; // 방문체크 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        startV = Integer.parseInt(br.readLine());

        // 인접리스트 초기화
        inList = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            inList[i] = new ArrayList<>();
        }

        // 인접리스트 구성
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            inList[from].add(new Node(to, cost));
        }

        // 배열 선언
        visited = new boolean[V + 1];
        D = new int[V + 1];
        Arrays.fill(D, Integer.MAX_VALUE / 4);
        minCostDistDji();

        // 다익스트라 함수 시작
        for (int i = 1; i <= V; i++) {
            if (D[i] == Integer.MAX_VALUE / 4) {
                bw.write("INF" + "\n");
            } else {
                bw.write(D[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 다익스트라 함수
    private static void minCostDistDji() {
        // 우선순위 큐 선언
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.nCost - o2.nCost;
            }
        });

        pq.add(new Node(startV, 0));
        D[startV] = 0;

        while (!pq.isEmpty()) {
            Node n = pq.poll();

            // 꺼낸 점이 방문한 점이면
            if (!visited[n.nV]) {
                visited[n.nV] = true;
            }

            // 인접한 리스트를 본다
            for (int i = 0; i < inList[n.nV].size(); i++) {
                // 인접한 점 꺼내기
                Node getNode = inList[n.nV].get(i);

                if (getNode != null && !visited[getNode.nV]) {
                    if (D[getNode.nV] > n.nCost + getNode.nCost) {
                        D[getNode.nV] = n.nCost + getNode.nCost;
                        pq.add(new Node(getNode.nV, D[getNode.nV]));
                    }
                }
            }
        }
    }
}