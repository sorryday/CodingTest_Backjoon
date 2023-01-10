package implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Marathon {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<Point> pointList = new ArrayList<>();
    static int pointCnt;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        pointCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < pointCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pointList.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int sum = 0;
        for (int i = 0; i < pointCnt - 1; i++) {
            sum += distanceHap(i, i + 1);
        }

        int result = sum;
        for (int i = 1; i < pointCnt - 1; i++) {
            int loopSum = sum - (distanceHap(i, i + 1) + distanceHap(i, i - 1)) + distanceHap(i - 1, i + 1);

            result = Math.min(loopSum, result);
        }

        bw.write(Integer.toString(result) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int distanceHap(int first, int second) {
        return Math.abs(pointList.get(first).x - pointList.get(second).x) + Math.abs(pointList.get(first).y - pointList.get(second).y);
    }
}
