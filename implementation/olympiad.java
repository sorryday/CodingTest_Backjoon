package implementation;

import java.io.*;
import java.util.*;

public class olympiad {
    static class Olympiad {
        int nation;
        int student_num;
        int score;

        public Olympiad(int nation, int student_num, int score) {
            this.nation = nation;
            this.student_num = student_num;
            this.score = score;
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<Olympiad> list = new ArrayList<>();
        Set<Integer> nationList = new LinkedHashSet<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Olympiad(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            nationList.add(list.get(i).nation);
        }

        Collections.sort(list, new Comparator<Olympiad>() {
            @Override
            public int compare(Olympiad o1, Olympiad o2) {
                return o2.score - o1.score;
            }
        });

        int[] nationCnt = new int[nationList.size() + 1];
        int cnt = 0;

        for (int i = 0; i < list.size(); i++) {
            if (nationCnt[list.get(i).nation] != 2 && cnt != 3) {
                nationCnt[list.get(i).nation] += 1;
                bw.write(list.get(i).nation + " " + list.get(i).student_num + "\n");

                cnt += 1;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}