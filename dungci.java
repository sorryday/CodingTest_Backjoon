import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class dungci {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> cm = new ArrayList<>();
        List<Integer> kg = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cm.add(Integer.parseInt(st.nextToken()));
            kg.add(Integer.parseInt(st.nextToken()));
        }

        int[] result = new int[N];

        for (int i = 0; i < N - 1; i++) {
            for (int j = i; j < N; j++) {
                if(cm.get(i) > cm.get(j) && kg.get(i) > kg.get(j)) {
                    result[j] += 1;
                }
                else if(cm.get(i) < cm.get(j) && kg.get(i) < kg.get(j)){
                    result[i] += 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            result[i] += 1;
            bw.write(Integer.toString(result[i]) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}