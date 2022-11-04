package binary_search;

import java.io.*;

public class DarkBridge {

    static String[] xArr;
    static int N;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); // 굴다리의 길이
        int M = Integer.parseInt(br.readLine()); // 가로등의 개수

        xArr = br.readLine().split(" ");

        int first = 0;
        int mid = 0;
        int last = N;

        while (first <= last) {
            mid = (first + last) / 2;

            if (lightPossible(mid)) {
                last = mid - 1;
            } else {
                first = mid + 1;
            }
        }

        bw.write(Integer.toString(first));
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean lightPossible(int mid) {
        int prev = 0; // 이전 가로등이 비춘 마지막 지점 (0부터 비춰야 하므로 0부터 시작)

        for (int i = 0; i < xArr.length; i++) {
            if (Integer.parseInt(xArr[i]) - mid <= prev) {
                prev = Integer.parseInt(xArr[i]) + mid;
            } else {
                return false;
            }
        }
        return N - prev <= 0;
    }
}