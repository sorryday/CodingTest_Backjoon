package backtracking;

import java.io.*;

public class Sudoku {
    static int[][] sudoku = new int[9][9]; // 스도쿠 맵

    static boolean[][] rowVisited = new boolean[9][10];  // 0번째 행에 0이 있다 -> row[0][0] = true;
    static boolean[][] colVisited = new boolean[9][10]; // 0번째 열에 0이 있다 -> col[0][0] = true;
    static boolean[][] gridVisited = new boolean[9][10];

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 스도쿠 입력 셋팅
        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = input.charAt(j) - '0';

                // 스도쿠의 값이 0이 아닐 때
                if (sudoku[i][j] != 0) {
                    // 행
                    rowVisited[i][sudoku[i][j]] = true;
                    // 열
                    colVisited[j][sudoku[i][j]] = true;
                    // 3*3
                    gridVisited[3 * (i / 3) + (j / 3)][sudoku[i][j]] = true;
                }
            }
        }

        // 0부터 80까지 일단 다 보는 백트래킹 함수 실행
        sudokuBackTracking(0);
    }

    // 스도쿠 백트래킹 함수
    private static void sudokuBackTracking(int depth) throws IOException {

        // 배열의 끝에 도달하면
        if (depth == 81) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    bw.write(Integer.toString(sudoku[i][j]));
                }
                bw.write("\n");
            }
            bw.flush();
            bw.close();
            br.close();

            System.exit(0);
        }

        // x좌표 : index / 9
        // y좌표 : index % 9
        int xf = depth / 9;
        int yf = depth % 9;

        // 만약 찾은 좌표에 해당하는 값이 0이면 값을 넣어줘야함
        if (sudoku[xf][yf] == 0) {
            for (int i = 1; i < 10; i++) {

                // 셋 중에 하나라도 사용한 수가 있다면 다른 수를 넣어봐야 한다.
                if (rowVisited[xf][i] || colVisited[yf][i] || gridVisited[3 * (xf / 3) + (yf / 3)][i]) {
                    continue;
                }

                // 하나의 수를 써도 세 경우 모두 적용 되므로 모두 true, false를 해줘야 한다.
                rowVisited[xf][i] = true;
                colVisited[yf][i] = true;
                gridVisited[3 * (xf / 3) + (yf / 3)][i] = true;

                // 스도쿠에 값 넣고 다음 재귀를 탄다.
                sudoku[xf][yf] = i;
                sudokuBackTracking(depth + 1);

                rowVisited[xf][i] = false;
                colVisited[yf][i] = false;
                gridVisited[3 * (xf / 3) + (yf / 3)][i] = false;
                sudoku[xf][yf] = 0;
            }

        } else { // 0이 아니면 그냥 다음 depth로 넘어간다.
            sudokuBackTracking(depth + 1);
        }
    }
}