package implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class lose_everyday {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> genmini = new ArrayList<>();
        List<Integer> startLink = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 9; i++) {
            genmini.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 9; i++) {
            startLink.add(Integer.parseInt(st.nextToken()));
        }

        int genminiCnt = 0;
        int startLinkCnt = 0;
        boolean flag = false;

        for (int i = 0; i < 9; i++) {
            genminiCnt += genmini.get(i);

            if (genminiCnt > startLinkCnt){
                flag = true;
                break;
            }
            startLinkCnt += startLink.get(i);
        }

        if (flag) {
            bw.write("Yes");
        }
        else {
            bw.write("No");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}