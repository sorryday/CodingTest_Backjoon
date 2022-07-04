import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class string_aggregate {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;

        List<String> nList = new ArrayList<>();
        List<String> mList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            nList.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            mList.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            if (nList.contains(mList.get(i))) {
                result += 1;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}