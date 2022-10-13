package implementation;

import java.io.*;

public class make_maze {
    static char[][] map;
    static int dir = 1;  // 0 : 동, 1 : 남, 2: 서, 3 : 북

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        String input = br.readLine();

        map = new char[101][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                map[i][j] = '#';
            }
        }

        int nowX = 50;
        int nowY = 50;
        map[nowX][nowY] = '.';

        for (int i = 0; i < cnt; i++) {
            char c = input.charAt(i);

            switch (c) {
                case 'F':
                    map[nowX + dy[dir]][nowY + dx[dir]] = '.';

                    nowX += dy[dir];
                    nowY += dx[dir];
                    break;

                case 'L':
                    setDirMethod(c);
                    break;

                case 'R':
                    setDirMethod(c);
                    break;
            }
        }

        int StartX = 0;
        int StartY = 0;

        int EndX = 0;
        int EndY = 0;

        int pointCnt = 0;

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (map[i][j] == '.') {
                    if (pointCnt == 0) {
                        StartX = i;
                        StartY = j;

                        EndX = i;
                        EndY = j;
                        pointCnt += 1;
                    }

                    else {
                        StartX = Math.min(StartX, i);
                        StartY = Math.min(StartY, j);

                        EndX = Math.max(EndX, i);
                        EndY = Math.max(EndY, j);
                    }
                }
            }
        }

        for (int i = StartX; i <= EndX; i++) {
            for (int j = StartY; j <= EndY; j++) {
                bw.write(map[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void setDirMethod(char c) {
        if (c == 'R') {
            if (dir == 0) {
                dir = 3;
            } else {
                dir -= 1;
            }
        } else if (c == 'L') {
            if (dir == 3) {
                dir = 0;
            } else {
                dir += 1;
            }
        }
    }
}
