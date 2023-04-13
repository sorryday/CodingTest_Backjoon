package UnionFind;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SwanLake {
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int R, C;
    static int result = 0;

    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean[][] swanVisited; // visited

    static Queue<Point> iceQ = new ArrayDeque<>(); // 백조가 얼음을 탐색하면 그 얼음의 좌표를 저장할 Q

    static int[] parent;
    static int[] swanVal = new int[2];  // [0] : 먼저 나온 백조, [1] 나중에 나온 백조

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 방문 배열 초기화
        swanVisited = new boolean[R][C];

        // 부모배열 초기화
        parent = new int[R * C + 2];

        // 맵에 값 입력
        map = new char[R][C];
        int idx = 0;
        for (int i = 0 ; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);

                if (map[i][j] != 'X') {
                    if (map[i][j] == 'L') {
                        swanVal[idx++] = i * C + j + 1;
                    }

                    check(i, j);
                }
            }
        }


        while (true) {

            if (find(swanVal[0]) == find(swanVal[1])) {
                break;
            }

            result++;

            // 얼음을 녹이는 함수
            meltIce();
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    // 얼음 녹이기
    private static void meltIce() {
        int size = iceQ.size();

        while (size-- > 0) {

            Point poll = iceQ.poll();
            for (int i = 0; i < 4; i++) {
                int xf = poll.x + dx[i];
                int yf = poll.y + dy[i];

                if (isAvailable(xf, yf) && map[xf][yf] == 'X') {
                    check(xf, yf);
                }
            }
        }
    }

    // 부모가 다른 애를 만났을 때 그 주변에 물이 있는 부분은 전부 같은 부모로 만들어줘야함
    private static void check(int x, int y) {
        map[x][y] = '.';

        iceQ.add(new Point(x, y));

        int tempParentFirst = find(x * C + y + 1);
        for (int i = 0; i < 4; i++) {
            int xf = x + dx[i];
            int yf = y + dy[i];

            if (isAvailable(xf, yf) && map[xf][yf] == '.') {
                int tempParentSecond = find(xf * C + yf + 1);

                if (tempParentFirst != tempParentSecond) {
                    parent[tempParentSecond] = tempParentFirst;
                }
            }
        }
    }

    // 범위를 넘는지 판단하는 함수
    private static boolean isAvailable (int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

    // 파인드
    private static int find(int x) {
        if (0 == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}