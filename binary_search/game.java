package binary_search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class game {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = getPercent(X, Y);

        int result = -1;
        int first = 0;
        int end = (int) 1e9;

        while (first <= end) {
            int mid = (first + end) / 2;

            if (getPercent(X + mid, Y + mid) != Z) {
                result = mid;
                end = mid - 1;
            }
            else {
                first = mid + 1;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    static int getPercent(int x, int y) {
        return (int) ((long) y * 100 / x);
    }
}
