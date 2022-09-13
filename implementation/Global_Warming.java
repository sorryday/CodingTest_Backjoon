package implementation;

import java.io.*;
import java.util.StringTokenizer;

public class Global_Warming {
    static String[][] map;
    static String[][] result;
    static int R, C;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        result = new String[R + 2][C + 2];

        map = new String[R + 2][C + 2];
        for (int i = 1; i <= R; i++) {
            String input = br.readLine();
            for (int j = 1; j <= C; j++) {
                map[i][j] = Character.toString(input.charAt(j - 1));
            }
        }

        for (int i = 0; i < R + 2; i++) {
            for (int j = 0; j < C + 2; j++) {
                if (i == 0 || i == R + 1) {
                    map[i][j] = ".";
                }
                else {
                    if (j == 0 || j == C + 1) {
                        map[i][j] = ".";
                    }
                }
            }
        }

        int minR = 12, minC = 12;
        int maxR = 0, maxC = 0;

        for (int i = 0; i < R + 2; i++) {
            for (int j = 0; j < C + 2; j++) {
                if (map[i][j].equals("X")) {
                    boolean flag = cnt_sea(i, j);
                    if (flag) {
                        result[i][j] = ".";
                    } else {
                        result[i][j] = "X";

                        minR = Math.min(minR, i);
                        minC = Math.min(minC, j);

                        maxR = Math.max(maxR, i);
                        maxC = Math.max(maxC, j);
                    }
                }
                else {
                    result[i][j] = ".";
                }
            }
        }

        for (int i = minR; i <= maxR; i++) {
            for (int j = minC; j <= maxC; j++) {
                bw.write(result[i][j]);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean cnt_sea(int x, int y) {
        int seaCnt = 0;
        for (int i = 0; i < 4; i++) {
            int xf = x + dx[i];
            int yf = y + dy[i];

            if (xf >= 0 && yf >= 0 && xf < R + 2 && yf < C + 2) {
                if (map[xf][yf].equals(".")) {
                    seaCnt += 1;
                }
            }
        }
        if (seaCnt >= 3) {
            return true;
        }
        else {
            return false;
        }
    }
}