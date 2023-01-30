import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class part_hap {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;  // 결과 배열의 시작 인덱스
        int end = 0;    // 결과 배열의 끝 인덱스

        int sum = 0;    // 배열의 start 인덱스 값부터 end 값까지의 합
        int result = Integer.MAX_VALUE;

        while (start <= N && end <= N) {
            // 1. sum이 M보다 크다면 그때의 배열의 길이를 갱신한다.
            if (sum >= M && result > end - start) {
                result = end - start;
            }

            // 2. sum이 M보다 작다면 end를 하나씩 더하고 그에 맞는 arr 값을 더해준다.
            if (sum < M) {
                sum += arr[end++];
            } else {
                sum -= arr[start++];
            }
        }

        if (result == Integer.MAX_VALUE) {
            bw.write("0");
        } else {
            bw.write(Integer.toString(result));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
