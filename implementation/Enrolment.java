package implementation;

import java.io.*;
import java.util.*;

public class Enrolment {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Set<String> set = new LinkedHashSet<>(); // LinkedHashSet : 입력한 순서가 보장된 해시셋
        for (int i = 0; i < L; i++) {
            String input = br.readLine();

            if (set.contains(input)) {
                set.remove(input);
            }
            set.add(input);
        }

        int cnt = 0;
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext() && cnt < K) {
            bw.write(iterator.next() + "\n");
            cnt += 1;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}