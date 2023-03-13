package binary_search;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ThreeSolution {
    static int N; // 용액수
    static List<Long> numList = new ArrayList<>(); // 용액 리스트
    static long result = Long.MAX_VALUE;

    static long leftResult = 0;
    static long midResult = 0;
    static long rightResult = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numList.add(Long.parseLong(st.nextToken()));
        }

        // 이분탐색을 위한 오름차순 정렬
        Collections.sort(numList);

        // 이분 탐색 함수 시작
        for (int i = 1; i < N - 1; i++) {
            twoPointSearch(i);
        }

        //결과 출력
        List<Long> sortList = new ArrayList<>();
        sortList.add(leftResult);
        sortList.add(midResult);
        sortList.add(rightResult);
        Collections.sort(sortList);

        bw.write(sortList.get(0) + " " + sortList.get(1) + " " + sortList.get(2));
        bw.flush();
        bw.close();
        br.close();
    }

    // 이분탐색 함수
    private static void twoPointSearch(int idx) {
        int left = 0;
        int right = numList.size() - 1;
        int mid = idx;

        while (left < right) {

            long hap = 0;
            hap = numList.get(mid) + numList.get(left) + numList.get(right);

            // 0에 가까운 값이므로 절대값으로 계산
            if (Math.abs(hap) <= Math.abs(result)) {
                result = Math.abs(hap);
                leftResult = numList.get(left);
                midResult = numList.get(mid);
                rightResult = numList.get(right);
            }

            // 합이 0보다 크다는 것은 나보다 큰 값을 가지는 배열의 인덱스를 줄여야 한다.
            if (hap > 0) {
                for (int i = right - 1; i >= 0; i--) {
                    if (i != mid) {
                        right = i;
                        break;
                    }
                }
            } else {    // 합이 0보다 작다는 것은 나보다 작은 값을 가지는 배열의 인덱스를 늘려야 한다.
                for (int i = left + 1; i < numList.size(); i++) {
                    if (i != mid) {
                        left = i;
                        break;
                    }
                }
            }
        }
    }
}