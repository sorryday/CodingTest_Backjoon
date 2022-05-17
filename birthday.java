import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class birthday {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[][] list = new String[n][4];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list[i][0] = st.nextToken();
            list[i][1] = st.nextToken();
            list[i][2] = st.nextToken();
            list[i][3] = st.nextToken();
        }
        Arrays.sort(list, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if(o1[3].equals(o2[3])) {
                    if(o1[2].equals(o2[2])) {
                        return Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]);
                    }
                    return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
                }
                return Integer.parseInt(o1[3]) - Integer.parseInt(o2[3]);
            }
        });

        bw.write(list[n - 1][0] + "\n" + list[0][0]);
        bw.flush();
        bw.close();
        br.close();
    }
}