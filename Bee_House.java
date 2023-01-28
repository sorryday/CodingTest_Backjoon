import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Bee_House {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        int range = 2;

        if (N == 1) {
            bw.write("1");
        } else {
            // 방의 개수는 6개씩 증가
            while (range <= N) {	// 범위가 N보다 커지기 직전까지 반복
                range = range + (6 * cnt);	// 다음 범위의 최솟값으로 초기화
                cnt += 1;	// count 1 증가
            }
            bw.write(Integer.toString(cnt));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
