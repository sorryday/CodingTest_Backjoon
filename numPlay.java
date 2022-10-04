import java.io.*;
import java.util.*;

public class numPlay {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] numArr = {"zero", "one", "two", "three", "four", "five", "six",
                "seven", "eight", "nine"};

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<String> list = new ArrayList<>();
        for (int i = M; i <= N; i++) {
            String integerToString = Integer.toString(i);
            StringBuffer sb = new StringBuffer();

            for (int j = 0; j < integerToString.length(); j++) {
                char c = integerToString.charAt(j);
                sb.append(numArr[c - '0'] + " ");
            }
            list.add(sb.toString());
        }

        Collections.sort(list);

        int cnt = 0;

        for (String s : list) {
            String[] split = s.split(" ");

            int result = 0;
            int k = 1;

            for (int i = split.length - 1; i >= 0; i--) {
                result += Arrays.asList(numArr).indexOf(split[i]) * k;
                k *= 10;
            }

            if (cnt == 10) {
                bw.write("\n");
                cnt = 0;
            }
            bw.write(Integer.toString(result) + " ");
            cnt += 1;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}