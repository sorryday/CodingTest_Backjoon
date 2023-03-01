package implementation;

import java.io.*;
import java.util.*;


public class SnakeBaekJoon {
    static int N, K, L;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};  // 0 : 북 , 1 : 동, 2 : 남 , 3 : 서
    static int[] dy = {0, 1, 0, -1};

    static boolean[][] visited;

    static int result = 0;

    static class Move {
        int time;
        char dirMove;

        public Move(int time, char dirMove) {
            this.time = time;
            this.dirMove = dirMove;
        }
    }

    static class Snake {
        int x;
        int y;
        int dir;

        public Snake(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }

    static Snake head;
    static Snake tail;

    static Queue<Move> moveQueue = new ArrayDeque<>();
    static Queue<Snake> dirQueue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 2; // 2 : 사과 위치
        }

        L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            moveQueue.add(new Move(Integer.parseInt(st.nextToken()) - 1, st.nextToken().charAt(0)));
        }

        head = new Snake(0, 0, 1);
        tail = new Snake(0, 0, 1);

        visited[0][0] = true;

        snakeMoveGame();

        bw.write(Integer.toString(result + 1));
        bw.flush();
        bw.close();
        br.close();
    }

    private static void snakeMoveGame() {
        while (true) {

            if (isAvailable(head.x + dx[head.dir], head.y + dy[head.dir])) {
                head.x += dx[head.dir];
                head.y += dy[head.dir];

                visited[head.x][head.y] = true;

                if (map[head.x][head.y] != 2) {
                    if (!dirQueue.isEmpty() && dirQueue.peek().x == tail.x && dirQueue.peek().y == tail.y) {
                        Snake poll = dirQueue.poll();
                        tail.dir = poll.dir;
                    }

                    visited[tail.x][tail.y] = false;

                    tail.x += dx[tail.dir];
                    tail.y += dy[tail.dir];
                } else {
                    map[head.x][head.y] = 0;
                }
            } else {
                break;
            }

            if (!moveQueue.isEmpty() && moveQueue.peek().time == result) {
                Move poll = moveQueue.poll();
                setDir(poll.dirMove, head);
                dirQueue.add(new Snake(head.x, head.y, head.dir));
            }

            result += 1;
        }
    }

    private static void setDir(char c, Snake s) {
        if (c == 'D') { // 시계방향 90도
            if (s.dir == 3) {
                s.dir = 0;
            } else {
                s.dir += 1;
            }
        } else {        // 반시계방향 90도
            if (s.dir == 0) {
                s.dir = 3;
            } else {
                s.dir -= 1;
            }
        }
    }

    private static boolean isAvailable(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < N && !visited[x][y]) {
            return true;
        }
        return false;
    }
}