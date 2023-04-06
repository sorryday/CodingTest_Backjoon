package bfs;

import java.io.*;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Puzzle {
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static Map<String, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        map = new int[3][3];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                sb.append(map[i][j]);
            }
        }

        // 배열의 값을 String 형태로 더하고 초기 값을 map에 저장한다.
        hashMap.put(sb.toString(), 0);

        // bfs 함수 시작
        puzzleBFS(sb.toString());

        if (hashMap.containsKey("123456780")) {
            bw.write(Integer.toString(hashMap.get("123456780")));
        } else {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void puzzleBFS(String firstString) {
        Queue<String> q = new ArrayDeque<>();
        q.add(firstString);

        while (!q.isEmpty()) {
            String poll = q.poll();
            int pollInt = hashMap.get(poll);

            // poll 값으로 0의 인덱스를 찾고 그 인덱스로 좌표 값을 구한다.
            int idx = poll.indexOf("0");

            int zeroX = idx / 3;
            int zeroY = idx % 3;

            for (int i = 0; i < 4; i++) {
                int xf = zeroX + dx[i];
                int yf = zeroY + dy[i];
                int movef = xf * 3 + yf;

                if (isAvailable(xf, yf)) {
                    // 내가 바꾸고자 하는 값의 인덱스를 저장한다.

                    StringBuilder sb = new StringBuilder();

                    // 두 위치를 바꿀 String 값을 저장한다.
                    char firstChar = poll.charAt(idx);
                    char secondChar = poll.charAt(movef);

                    sb.append(poll);
                    sb.setCharAt(idx, secondChar);
                    sb.setCharAt(movef, firstChar);

                    // 바꾸었을 때 이미 맵에 있는 값이면 무시하고 맵에 없다면 이동 값에 + 1을 해준 값을 map에 넣어준다.
                    if (!hashMap.containsKey(sb.toString())) {
                        hashMap.put(sb.toString(), pollInt + 1);
                        q.add(sb.toString());
                    }
                }
            }
        }
    }

    private static boolean isAvailable(int x, int y) {
        return x >= 0 && x < 3 && y >= 0 && y < 3;
    }
}
