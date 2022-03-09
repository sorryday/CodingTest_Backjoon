import java.io.*;

public class Candy_Game {
    static char[][] arr;
    static int max = 1;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        cnt = Integer.parseInt(br.readLine());
        arr = new char[cnt][cnt];

        for(int i = 0; i < cnt; i++) {
            String st = br.readLine();
            for (int j = 0; j < cnt; j++) {
                arr[i][j] = st.charAt(j);
            }
            max = Math.max(max, chkRow(i));  // 바꾸기전 행 체크
        }

        for(int i = 0; i < cnt; i++) {  // 바꾸기전 열 체크
            max = Math.max(max, chkCol(i));
        }

        for(int i = 0; i < cnt; i++) {
            for(int j = 0; j < cnt; j++) {
                if(j + 1 < cnt) {
                    swap(i, j, i, j + 1);
                    max = Math.max(max, chkRow(i));
                    max = Math.max(max, chkCol(j));
                    max = Math.max(max, chkCol(j + 1));
                    swap(i, j, i, j + 1);
                }

                if(i + 1 < cnt) {
                    swap(i, j, i + 1, j);
                    max = Math.max(max, chkRow(i));
                    max = Math.max(max, chkRow(i + 1));
                    max = Math.max(max, chkCol(j));
                    swap(i, j, i + 1, j);
                }
            }
        }
        bw.write(Integer.toString(max));
        bw.flush();
        bw.close();
        br.close();
    }
    public static int chkRow(int x) { // 행 체크
        int tmp = 1, res = 1;
        char ch = arr[x][0];
        for(int i = 1; i < cnt; i++) {
            if(arr[x][i] != ch) {
                ch = arr[x][i];
                res = Math.max(res, tmp);
                tmp = 1;
            } else tmp++;
        }
        return Math.max(res, tmp);
    }

    public static int chkCol(int y) { // 열 체크
        int tmp = 1, res = 1;
        char ch = arr[0][y];
        for(int i = 1; i < cnt; i++) {
            if(arr[i][y] != ch) {
                ch = arr[i][y];
                res = Math.max(res, tmp);
                tmp = 1;
            } else tmp++;
        }
        return Math.max(res, tmp);
    }

    public static void swap(int x1, int y1, int x2, int y2) {
        char tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;
    }
}
