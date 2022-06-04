import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Inet4Address;
import java.util.*;

class FBI {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String t = br.readLine();
            if(t.contains("FBI")) {
                list.add(i + 1);
            }
        }

        if(list.size() == 0) {
            bw.write("HE GOT AWAY!");
        }
        else {
            for (int i = 0; i < list.size(); i++) {
                bw.write(list.get(i) + " ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}