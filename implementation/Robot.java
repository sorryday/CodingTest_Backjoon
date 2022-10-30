package implementation;

import java.io.*;
import java.util.StringTokenizer;

public class Robot {

    static int[] dir = {0, 1, 2, 3};  // 동남서북
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int myDir = 0;
    static int myX = 0;
    static int myY = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();
            int commendNum = Integer.parseInt(st.nextToken());

            switch (commend) {
                case "MOVE":
                    myX += dx[dir[myDir]] * commendNum;
                    myY += dy[dir[myDir]] * commendNum;

                    if (myX < 0 || myX >= M || myY < 0 || myY >= M) {
                        bw.write("-1");
                        bw.flush();
                        bw.close();
                        br.close();

                        return;
                    }
                    break;

                case "TURN":
                    setDir(commendNum);
                    break;
            }
        }
        bw.write(Integer.toString(myX) + " " + Integer.toString(myY));
        bw.flush();
        bw.close();
        br.close();
    }

    // 방향전환 함수
    private static void setDir(int commendNum) {
        // 왼쪽으로 90도 이동
        if (commendNum == 0) {
            if (myDir == 0) {
                myDir = 3;
            } else {
                myDir -= 1;
            }
        }

        // 오른쪽으로 90도 이동
        else {
            if (myDir == 3) {
                myDir = 0;
            } else {
                myDir += 1;
            }
        }
    }
}

