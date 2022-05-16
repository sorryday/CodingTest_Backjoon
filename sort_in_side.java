import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class sort_in_side {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String N = br.readLine();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < N.length(); i++) {
            list.add(N.charAt(i));
        }

        Collections.sort(list, Comparator.reverseOrder());
        for (int i = 0; i < list.size(); i++) {
            bw.write(list.get(i));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}