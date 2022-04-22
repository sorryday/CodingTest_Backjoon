import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class ArrayHap {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            if(i == 0) {
                for (int j = 0; j < N; j++) {
                    list.add(Integer.parseInt(st.nextToken()));
                }
            }
            else{
                for (int j = 0; j < M; j++) {
                    list.add(Integer.parseInt(st.nextToken()));
                }
            }
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            bw.write(Integer.toString(list.get(i)) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}