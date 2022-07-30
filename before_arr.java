import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class before_arr {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (before_arr(arr)) {
            for (int i = 0; i < N; i++) {
                bw.write(arr[i] + " ");
            }
        }
        else {
            bw.write("-1");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean before_arr(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i] >= arr[i - 1]) {
            i -= 1;
        }

        if (i <= 0) {
            return false;
        }

        int j = arr.length - 1;
        while (arr[i - 1] <= arr[j]) {
            j -= 1;
        }
        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        j = arr.length - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}