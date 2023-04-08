package greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CupNoodle {

    static class Noodle {
        long deadLine;
        long noodleCnt;
        public Noodle(long deadLine, long noodleCnt) {
            this.deadLine = deadLine;
            this.noodleCnt = noodleCnt;
        }
    }

    static long result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 최적의 해를 찾기 위한 라면의 수가 저장되어 있을 pq
        PriorityQueue<Long> pq = new PriorityQueue<>(new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return (int) (o1 - o2);
            }
        });

        List<Noodle> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long deadLine = Integer.parseInt(st.nextToken());
            long noodleCnt = Integer.parseInt(st.nextToken());

            list.add(new Noodle(deadLine, noodleCnt));
        }

        Collections.sort(list, new Comparator<Noodle>() {
            @Override
            public int compare(Noodle o1, Noodle o2) {
                if (o1.deadLine == o2.deadLine) {
                    return (int) (o1.noodleCnt - o2.noodleCnt);
                }
                return (int) (o1.deadLine - o2.deadLine);
            }
        });

        for (int i = 0; i < list.size(); i++) {
            Noodle getNoodle = list.get(i);

            pq.add(getNoodle.noodleCnt);
            if (pq.size() > getNoodle.deadLine) {
                pq.poll();
            }
        }

        while (!pq.isEmpty()) {
            result += pq.poll();
        }

        bw.write(Long.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
