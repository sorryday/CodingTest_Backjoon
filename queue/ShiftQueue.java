package queue;
import java.io.*;
import java.util.*;

public class ShiftQueue {

    static int N, M;
    static int cnt = 0;

    static LinkedList<Integer> queue;
    static List<Integer> SelectedWant;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.offer(i + 1);
        }

        SelectedWant = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            SelectedWant.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            if (Check(SelectedWant.get(i))) {  // 찾으려는 위치가 큐 크기 절반보다 작다면 왼쪽으로 이동
                while (queue.get(0) != SelectedWant.get(i)) {
                    queue.addLast(queue.pollFirst());
                    cnt += 1;
                }

            } else {                // 찾으려는 위치가 큐 크기 절반보다 크다면 오른쪽으로 이동
                while (queue.get(0) != SelectedWant.get(i)) {
                    queue.addFirst(queue.pollLast());
                    cnt += 1;
                }
            }

            queue.poll();
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean Check(int peeked) {
        for (int i = 0; i <= queue.size() / 2; i++) {
            if (peeked == queue.get(i)) {
                return true;
            }
        }

        return false;
    }
}