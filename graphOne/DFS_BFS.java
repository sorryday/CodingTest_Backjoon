package graphOne;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class DFS_BFS {
    static boolean[] visited;
    static int[][] line = new int[1001][1001];

    static int N; // 정점의 개수
    static int M; // 간선의 개수
    static int V; // 간선의 개수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[1001];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            line[x][y] = line[y][x] = 1;
        }

        DFS(V);
        System.out.println();
        visited = new boolean[1001];

        BFS();
    }

    static void DFS(int V) {
        visited[V] = true;
        System.out.print(V + " ");

        for (int i = 1; i <= N; i++) {
            if (line[V][i] == 1 && visited[i] == false) {
                DFS(i);
            }
        }
    }

    static void BFS() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(V); //시작점도 Queue에 넣어야 함
        visited[V] = true;
        System.out.print(V + " ");

        //Queue가 빌 때까지 반복. 방문 정점은 확인, 출력 후 Queue에 넣어 순서대로 확인
        while(!queue.isEmpty()) {
            int temp = queue.poll();

            for(int j = 1; j <= N; j++) {
                if(line[temp][j] == 1 && visited[j] == false) {
                    queue.offer(j);
                    visited[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
    }
}
