package binary_search;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class numSearch {
    static int[] nList;
    static int[] mList;
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Integer> t = new ArrayList<>();

        N = Integer.parseInt(br.readLine());
        nList = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nList[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nList);

        M = Integer.parseInt(br.readLine());
        mList = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            mList[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            bw.write(Integer.toString(bin_search(i)) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int bin_search(int i) {
        int start = 0;
        int end = N - 1;
        int mid = (start + end) / 2;

        while(end - start >= 0) {
            if (mList[i] == nList[mid]) {
                return 1;
            }
            else if (mList[i] <= nList[mid]){
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
            mid = (end + start) / 2;
        }
        return 0;
    }
}