package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class BreakedWall {
    static int N, M;
    static int[][] map;
    static int[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int result = Integer.MAX_VALUE;

    static class Point {
        int x;
        int y;
        int move;
        int visitedCnt; // 벽을 부순 횟수 (벽을 부쉈는지 아닌지 boolean으로는 할 수 없음)

        public Point(int x, int y, int move, int visitedCnt) {
            this.x = x;
            this.y = y;
            this.move = move;
            this.visitedCnt = visitedCnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
                visited[i][j] = 2; // visited 카운트를 2로 초기화, 어차피 벽은 1번 밖에 못 부시므로 1 이상의 값이 나올 수 없다.
            }
        }
        breakWallBFS(0, 0, 1, 0);

        if (result == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(Integer.toString(result));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void breakWallBFS(int x, int y, int move, int visitedCnt) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, move, visitedCnt));
        visited[x][y] = 0;

        while (!q.isEmpty()) {
            Point poll = q.poll();

            if (poll.x == N - 1 && poll.y == M - 1) {
                result = Math.min(result, poll.move);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int xf = poll.x + dx[i];
                int yf = poll.y + dy[i];

                if (xf >= 0 && xf < N && yf >= 0 && yf < M && (visited[xf][yf] > poll.visitedCnt)) {
                    // 벽을 만났음
                    if (map[xf][yf] == 1) {
                        if (poll.visitedCnt == 0) { // 지금 큐에서 꺼낸 객체(탐색하고 있는 객체)가 한번도 벽을 안 부쉈다면
                            visited[xf][yf] = poll.visitedCnt + 1;
                            q.add(new Point(xf, yf, poll.move + 1, poll.visitedCnt + 1));
                        }

                        // 지금 큐에서 꺼낸 객체(탐색하고 있는 객체)가 한번이라도 벽을 부쉈다면 벽을 또 부술 수 없으므로 기각
                    }

                    // 벽이 아닌 경우 : 그대로 탐색 진행
                    else if (map[xf][yf] == 0) {
                        visited[xf][yf] = poll.visitedCnt;
                        q.add(new Point(xf, yf, poll.move + 1, poll.visitedCnt));
                    }
                }
            }
        }
    }
}