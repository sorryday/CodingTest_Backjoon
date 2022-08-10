package simulation;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class recommend_candidate {
    static class Info {
        public int student_name; // 학생의 이름
        public int recomm_cnt = 0; // 특정 학생의 추천수

        public Info(int student_name) {
            this.student_name = student_name;
        }
    }

    static boolean flag = false;
    static int[] recommend;
    static List<Info> frame = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());  // 사진틀의 개수
        int student = Integer.parseInt(br.readLine()); // 학생들의 추천수

        recommend = new int[student];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < student; i++) {
            recommend[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < student; i++) {
            Info info = new Info(recommend[i]);

            if (frame.isEmpty()) {                                      // 사진 틀이 비어있을 때
                info.recomm_cnt += 1;
                frame.add(info);
            }

            else if (frame.size() <= N) {
                plusRecommend(i);

                if (!flag && frame.size() < N) {                            // 추천 받은 학생이 프레임에 없을 경우
                    info.recomm_cnt += 1;
                    frame.add(info);
                }

                else if (!flag && frame.size() == N) {
                    int idx = 0;
                    int min = Integer.MAX_VALUE;

                    for (int k = 0; k < frame.size(); k++) {            // 남은 프레임이 없고 새로운 사람이 추천 받았을 떄.
                        if (frame.get(k).recomm_cnt < min) {
                            min = frame.get(k).recomm_cnt;
                            idx = k;
                        }
                    }

                    frame.remove(idx);
                    info.recomm_cnt += 1;
                    frame.add(info);
                }
            }
            flag = false;
        }

        List<Integer> out = new ArrayList<>();
        for (Info info : frame) {
            out.add(info.student_name);
        }

        Collections.sort(out);
        for (int i = 0; i < out.size(); i++) {
            bw.write(Integer.toString(out.get(i)) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static public void plusRecommend(int i) {
        for (int j = 0; j < frame.size(); j++) {
            if (frame.get(j).student_name == recommend[i]) {      // 이미 있는 학생의 추천수를 하나 증가.
                frame.get(j).recomm_cnt += 1;

                flag = true;
                break;
            }
        }
    }
}