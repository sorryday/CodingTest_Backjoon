package implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Subject_is_not_end {
    static class Subject {
        int score;
        int min;

        public Subject(int score, int min) {
            this.score = score;
            this.min = min;
        }
    }
    static List<Subject> subjectList = new ArrayList<>();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("1")) {
                Subject subject = new Subject(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                subjectList.add(subject);
            }
            subjectWork();
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }

    static public void subjectWork() {
        if (!subjectList.isEmpty()) {
            if (subjectList.get(subjectList.size() - 1).min != 0) {
                subjectList.get(subjectList.size() - 1).min -= 1;
            }

            if (subjectList.get(subjectList.size() - 1).min == 0) {
                result += subjectList.get(subjectList.size() - 1).score;
                subjectList.remove(subjectList.get(subjectList.size() - 1));
            }
        }
    }
}