package backtracking;

import java.io.*;

public class SevenPrincess {
    static char[][] map = new char[5][5];
    static char[][] selectedMap = new char[5][5];

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int result = 0;
    static int selectedCnt = 0;

    static boolean[][] visited;  // 탐색을 위한 방문배열

    static boolean[] selectedStudentArr; // 선택한 학생 arr

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 자리 입력
        for (int i = 0; i < 5; i++) {
            String input = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        // 학생를 고를 BackTracking 함수
        selectedStudentArr = new boolean[25];
        selectedStudentBackTracking(0, 0, 0, 0);

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    // 학생를 고를 BackTracking 함수
    private static void selectedStudentBackTracking(int cnt, int depth, int sCnt, int yCnt) {
        if (cnt == 7) {
            if (sCnt >= 4) {
                // 방문 배열 초기화
                visited = new boolean[5][5];

                for (int i = 0; i < 25; i++) {
                    if (selectedStudentArr[i]) {
                        splitBackTracking(i / 5, i % 5);

                        if (selectedCnt == 7) {
                            result++;
                        }
                        break;
                    }
                }
            }

            selectedCnt = 0;
            return;
        }

        for (int i = depth; i < 25; i++) {
            selectedStudentArr[i] = true;

            selectedMap[i / 5][i % 5] = map[i / 5][i % 5];

            if (map[i / 5][i % 5] == 'S') {
                selectedStudentBackTracking(cnt + 1, i + 1, sCnt + 1, yCnt);
            } else {
                selectedStudentBackTracking(cnt + 1, i + 1, sCnt, yCnt + 1);
            }

            selectedStudentArr[i] = false;
            selectedMap[i / 5][i % 5] = ' ';
        }
    }

    // 학생를 나눌 BackTracking 함수
    private static void splitBackTracking(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int xf = x + dx[i];
            int yf = y + dy[i];

            if (isAvailable(xf, yf) && !visited[xf][yf] && (selectedMap[xf][yf] == 'S' || selectedMap[xf][yf] == 'Y')) {
                visited[xf][yf] = true;
                selectedCnt++;
                splitBackTracking(xf, yf);
            }
        }
    }

    // 범위를 넘는지 판단하는 함수
    private static boolean isAvailable(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
}
