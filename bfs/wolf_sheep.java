package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class wolf_sheep {
    static int r, c;
    static char[][] map;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean flag = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'W') {
                    q.add(new int[]{i, j}); // 늑대의 위치를 q에 insert
                }
            }
        }
        bfs();

        if (flag) {
            bw.write("1" + "\n");

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    bw.write(map[i][j]);
                }
                bw.write("\n");
            }
        }
        else {
            bw.write("0");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static public void bfs() {
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0];
            int y = t[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (map[nx][ny] == '.') {
                        map[nx][ny] = 'D';
                    }
                    if (map[nx][ny] == 'S') { // 양이 바로 옆이면 울타리 설치 불가
                        flag = false;
                        return;
                    }
                }
            }
        }
    }
}