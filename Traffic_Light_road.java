import java.io.*;
import java.util.StringTokenizer;

class Traffic_Light_road {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 신호등 개수
        int L = Integer.parseInt(st.nextToken());  // 도로의 길이

        int resultCnt = 0;
        int position = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());

            resultCnt += D - position;
            position = D;

            int min = resultCnt % (R + G);
            if (min < R) {
                resultCnt += R - min;
            }
        }

        resultCnt += L - position;

        bw.write(Integer.toString(resultCnt));
        bw.flush();
        bw.close();
        br.close();
    }
}