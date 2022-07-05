package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class A_B {
    static int result = 0;
    static long A = 0;
    static long B = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        System.out.println(changeNum());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int changeNum() {
        Queue<Long> queue = new LinkedList<>();
        queue.add(A);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                long temp = queue.poll();
                if (temp == B) {
                    return result + 1;
                }

                if (temp * 2 <= B) {
                    queue.add(temp * 2);
                }
                if (temp * 10 + 1 <= B) {
                    queue.add(temp * 10 + 1);
                }
            }
            result++;
        }
        return -1;
    }
}
