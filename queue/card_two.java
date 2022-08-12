package queue;

import java.io.*;
import java.util.*;

class card_two {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (N-- > 1) {
            // 맨 위의 카드를 한장 버린다.
            queue.poll();

            // 그 다음 위에 있는 카드를 빼서 맨 아래에 놓는다.
            queue.offer(queue.poll());
        }

        bw.write(Integer.toString(queue.poll()));
        bw.flush();
        bw.close();
        br.close();
    }
}