package bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class hide_seek {
    static int N;
    static int K;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
        }
        else {
            bfs(N);
        }
    }

    public static void bfs(int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 1;

        while (!queue.isEmpty()) {      // 큐가 비어있지 않을 때까지
            int temp = queue.poll();

            for (int i = 0; i < 3; i++) {  // 경우의 수가 3가지이므로 3번을 돌아야함 (1. +1, 2. -1, 3. *2)
                int next = 0;
                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }
                if (next == K) {
                    System.out.println(visited[temp]);
                    return;
                }

                if (next <= 100000 && next >= 0 && visited[next] == 0) {
                    queue.add(next);
                    visited[next] = visited[temp] + 1;
                }
            }
        }
    }
}