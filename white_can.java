import java.io.*;
import java.util.StringTokenizer;

public class white_can {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[][] map = new char[8][8];
        int result = 0;

        for (int i = 0; i < 8; i++) {
            String input = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = input.charAt(j);

                if ((i + j) % 2 == 0 && map[i][j] == 'F') {
                    result += 1;
                }
            }
        }
        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}