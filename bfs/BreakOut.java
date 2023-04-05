package bfs;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreakOut {
    static int R, C;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int resultTime = Integer.MAX_VALUE;

    static int myX, myY;

    static class Point {
        int x;
        int y;
        int moveTime;

        public Point(int x, int y, int moveTime) {
            this.x = x;
            this.y = y;
            this.moveTime = moveTime;
        }
    }

    static boolean[][] visited;
    static boolean[][] waterVisited;
    static Queue<Point> waterQueue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 물 방문 처리 배열을 미리 만들어둔다.
        waterVisited = new boolean[R][C];

        // 맵 값 입력
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);

                // 비버의 위치를 기억 및 '.'으로 변경
                if (map[i][j] == 'S') {
                    myX = i;
                    myY = j;
                    map[i][j] = '.';
                }

                // 물의 위치를 미리 큐에 담는다.
                if (map[i][j] == '*') {
                    waterQueue.add(new Point(i, j, 0));
                    waterVisited[i][j] = true;
                }
            }
        }

        // BFS 함수 시작
        visited = new boolean[R][C];
        breakOutBFS();

        // 결과 출력
        if (resultTime == Integer.MAX_VALUE) {
            bw.write("KAKTUS");
        } else {
            bw.write(Integer.toString(resultTime));
        }

        bw.flush();
        bw.close();
        br.close();
    }

    // 탈출하는지 판단하는 BFS 함수
    private static void breakOutBFS() {
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(myX, myY, 0));
        visited[myX][myY] = true;

        while (!q.isEmpty()) {
            int time = q.size();

            while (time-- > 0) {
                // 비버 poll
                Point poll = q.poll();

                // 도착한다면 탈출
                if (map[poll.x][poll.y] == 'D') {
                    resultTime = Math.min(resultTime, poll.moveTime);
                }

                // 꺼낸 객체가 이미 물에 차있으면
                if (map[poll.x][poll.y] == '*') {
                    continue;
                }

                // 비버 이동
                for (int i = 0; i < 4; i++) {
                    int xf = poll.x + dx[i];
                    int yf = poll.y + dy[i];

                    if (isAvailable(xf, yf) && !visited[xf][yf] && (map[xf][yf] == '.' || map[xf][yf] == 'D')) {
                        visited[xf][yf] = true;
                        q.add(new Point(xf, yf, poll.moveTime + 1));
                    }
                }
            }
            waterBFS();
        }
    }

    // 물을 채우는 함수
    private static void waterBFS() {
        // 물 poll
        int time = waterQueue.size();
        while (time-- > 0) {
            Point waterPoll = waterQueue.poll();

            for (int i = 0; i < 4; i++) {
                int waterX = waterPoll.x + dx[i];
                int waterY = waterPoll.y + dy[i];

                if (isAvailable(waterX, waterY) && !waterVisited[waterX][waterY] && map[waterX][waterY] == '.') {
                    waterVisited[waterX][waterY] = true;
                    map[waterX][waterY] = '*';
                    waterQueue.add(new Point(waterX, waterY, 0));
                }
            }
        }
    }

    // 범위를 넘는지 판단하는 함수
    private static boolean isAvailable(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
