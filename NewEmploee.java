import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class NewEmploee {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        List<Integer> em = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int result = 1;  // 면접의 최소 값을 가지는 애를 무조건 합격한다고 하고 계산

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                em.add(x);
                map.put(x, y);
            }
            Collections.sort(em);
            int minY = map.get(em.get(0)); // 면접의 최소 값을 가지는 애를 무조건 합격한다고 하고 계산

            for (int j = 1; j < N; j++) {
                if(map.get(em.get(j)) < minY) {
                    result += 1;
                    minY = map.get(em.get(j));
                }
            }

            bw.write(Integer.toString(result) + "\n");
            em.clear();
            map.clear();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}