package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class night {
    static int [][] visited = new int[301][301];
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
    static int I;  // 체스판 크기
    static int test = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {

            for (int j = 0; j <= 300; j++) {
                for (int k = 0; k <= 300; k++) {
                    visited[j][k] = -1;
                }
            }

            I = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int fx = Integer.parseInt(st.nextToken());
            int fy = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());


            bfs(fx, fy, rx, ry);
            bw.write(Integer.toString(visited[rx][ry]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int fx, int fy, int rx, int ry) {
        Queue<point> queue = new LinkedList<>();
        queue.add(new point(fx, fy));
        visited[fx][fy] = 0;

        while (!queue.isEmpty()) {
            point p = queue.poll();
            if(p.x == rx && p.y == ry) {
                break;
            }

            for (int i = 0; i < 8; i++) {
                int tx = p.x + dx[i];
                int ty = p.y + dy[i];

                if(tx >= 0 && tx < I && ty >=0 && ty < I && (visited[tx][ty] == -1 || visited[p.x][p.y] + 1 < visited[tx][ty])) {
                    visited[tx][ty] = visited[p.x][p.y] + 1;
                    queue.add(new point(tx, ty));
                }
            }
        }
    }

    static class point {
        int x;
        int y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
