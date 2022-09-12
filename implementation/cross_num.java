package implementation;

import java.io.*;
import java.util.StringTokenizer;

public class cross_num {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int input_num = getMinNum(a, b, c, d);
        boolean[] clock_num = compareNumMethod();
        int result = 0;

        for (int i = 1111; i <= input_num ; i++) {
            if (clock_num[i]) {
                result += 1;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    static public boolean[] compareNumMethod() {
        boolean[] visited = new boolean[10001];

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    for (int l = 1; l < 10; l++) {
                        int n = getMinNum(i, j, k, l);

                        if (!visited[n]) {
                            visited[n] = true;
                        }
                    }
                }
            }
        }
        return visited;
    }

    public static int getMinNum(int a, int b, int c, int d) {
        int min = Integer.MAX_VALUE;

        min = Math.min(min, a * 1000 + b * 100 + c * 10 + d);
        min = Math.min(min, b * 1000 + c * 100 + d * 10 + a);
        min = Math.min(min, c * 1000 + d * 100 + a * 10 + b);
        min = Math.min(min, d * 1000 + a * 100 + b * 10 + c);

        return min;
    }
}