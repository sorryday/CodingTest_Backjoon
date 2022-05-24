import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class coin_zero {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        List<Long> list = new ArrayList<>();

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            list.add(Long.parseLong(br.readLine()));
        }
        Collections.sort(list, Collections.reverseOrder());

        for (int i = 0; i < list.size(); i++) {
            cnt += K / list.get(i);
            K = K % list.get(i);
        }

        bw.write(Integer.toString(cnt));
        bw.flush();
        bw.close();
        br.close();
    }
}