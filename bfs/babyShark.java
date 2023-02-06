package bfs;

import java.io.*;
import java.util.*;

public class babyShark {
    static int N;
    static int[][] map;

    static int[] dx = {1, -1 , 0, 0};
    static int[] dy = {0, 0 , -1, 1};

    static int result = 0;  // 이동하는데 걸린 시간

    static class Point {
        int x;
        int y;
        int size; // 상어의 사이즈
        int cnt;  // 먹은 물고기의 개수
        int move; // 이동한 거리

        public Point(int x, int y, int size, int cnt, int move) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.cnt = cnt;
            this.move = move;
        }
    }

    static PriorityQueue<Point> pq; // bfs 한바퀴를 돌았을 때 먹을 수 있는 먹이를 저장한 큐

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        Point shark = null;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    shark = new Point(i, j, 2, 0, 0);
                    map[i][j] = 0;      // 상어가 있는 자리를 0으로 치환(나중에 탐색할 수 있으므로)
                }
            }
        }

        babySharkSearch(shark);

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    // 먹이를 찾는 bfs
    private static void babySharkSearch(Point shark) {
        // 먹이들의 위치를 저장하는 큐
        pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                // 거리가 같다면
                if (o1.move == o2.move) {
                    // 거리가 같다면 위쪽에 있는 먹이를 먹어야 하므로 x값을 비교
                    // 그 x값이 같다면 가장 왼쪽에 있는 먹이를 먹어야 하므로 y값이 작은것으로 정렬
                    if (o1.x == o2.x) {
                        return o1.y - o2.y;
                    } else {
                        return o1.x - o2.x;
                    }
                } else {
                    return o1.move - o2.move;
                }
            }
        });

        // bfs를 한번 탐색하면 현재의 상어 위치에서 탐색할 수 있는 먹이들이 pq에 들어간다.
        // 만약 먹이를 먹었다면 그 위치에서부터 다시 나머지 먹이들을 탐색해줘야한다.

        // bfs 탐색에 이용되는 큐
        Queue<Point> q = new LinkedList<>();
        q.add(shark);

        while (true) {
            boolean[][] visited = new boolean[N][N];

            while (!q.isEmpty()) {
                Point poll = q.poll();

                if (!visited[poll.x][poll.x]) {
                    visited[poll.x][poll.y] = true;
                }

                for (int i = 0; i < 4; i++) {
                    int xf = poll.x + dx[i];
                    int yf = poll.y + dy[i];

                    if (xf >= 0 && xf < N && yf >= 0 && yf < N && !visited[xf][yf] && map[xf][yf] <= poll.size) {
                        // 먹이를 먹을 수 있는 경우(현재 상어의 크기가 먹이보다 클 경우) 먹이리스트(pq)에 저장
                        if (map[xf][yf] < poll.size && map[xf][yf] != 0) {
                            pq.add(new Point(xf, yf, poll.size, poll.cnt + 1, poll.move + 1));
                        }

                        visited[xf][yf] = true;
                        q.add(new Point(xf, yf, poll.size, poll.cnt, poll.move + 1));
                    }
                }
            }

            // 더이상 먹을 수 있는 먹이가 없다면
            if (pq.isEmpty()) {
                break;
            }

            // bfs 한바퀴를 돌았다면 (현재 상어의 위치에서 먹을 수 있는 먹이를 우선순위에 맞게 서치했다면) 먹이 함수 실행
            // 먹이 함수가 끝난 후 그 위치부터 다시 탐색해야 하므로 bfs 큐(q)에 넣는다.
            q.add(eat());

            // 다시 탐색해야 하므로 먹이 큐 초기화
            pq.clear();
        } // while(true)
    } // babySharkSearch

    // 먹이를 먹는 함수
    // 하나만 꺼내는 이유 : 먹이를 먹고 다시 우선순위에 따라 탐색해줘야 하기 때문에
    // 그렇다면 bfs를 돌 때 먹이를 찾으면 바로 bfs를 종료시키는 건 안되는가? : 먹이들의 우선순위를 찾아야하기 때문
    private static Point eat() {
        Point poll = pq.poll();

        // 크기가 2인 상어는 2마리의 물고기를 먹어야 크기가 +1 되므로
        if (poll.size == poll.cnt) {
            poll.size++;
            poll.cnt = 0;
        }

        // 이 먹이를 먹을 때까지 이동한 거리 값을 합함
        result += poll.move;

        // 그 위치의 먹이를 먹었으므로 map에서 0으로 만들어줘야함
        map[poll.x][poll.y] = 0;

        return new Point(poll.x, poll.y, poll.size, poll.cnt, 0);
    }
}