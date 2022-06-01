import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class starbucks_line {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long result = 0;
        List<Integer> list = new ArrayList<>();
        long N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list, Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            long temp = list.get(i) - (i);
            if(temp > 0) {
                result += temp;
            }
        }

        bw.write(Long.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}