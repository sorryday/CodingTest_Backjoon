import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class hearsay {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> name = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<String> list = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            name.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String t = br.readLine();
            if(name.contains(t)) {
                list.add(t + "\n");
            }
        }
        Collections.sort(list);

        bw.write(Integer.toString(list.size()) + "\n");
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}