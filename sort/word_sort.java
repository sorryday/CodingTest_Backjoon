package sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> list = new ArrayList<>();
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            list.add(br.readLine());
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                else {
                    return o1.length() - o2.length();
                }
            }
        });

        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                bw.write(list.get(i) + "\n");
            }
            if (i != 0 && !list.get(i).equals(list.get(i - 1))) {
                bw.write(list.get(i) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}