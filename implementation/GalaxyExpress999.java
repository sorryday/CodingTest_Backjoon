package implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class GalaxyExpress999 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 1;

        List<boolean[]> trains = new ArrayList<>();
        List<boolean[]> trainsHistory = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            boolean[] inputArr = new boolean[20];

            for (int j = 0; j < 20; j++) {
                inputArr[j] = false;
            }

            trains.add(inputArr);
        }

        for (int p = 0; p < M; p++) {
            st = new StringTokenizer(br.readLine());

            int order = Integer.parseInt(st.nextToken());
            int trainNum = Integer.parseInt(st.nextToken());
            int sitNum = 0;

            if (order == 1 || order == 2) {
                sitNum = Integer.parseInt(st.nextToken());
            }

            boolean[] arr = trains.get(trainNum - 1);
            switch (order) {
                case 1:
                    if (!arr[sitNum - 1]) {
                        arr[sitNum - 1] = true;
                    }
                    break;

                case 2:
                    if (arr[sitNum - 1]) {
                        arr[sitNum - 1] = false;
                    }
                    break;

                case 3:
                    for(int i = 19; i >= 1; i--) {
                        arr[i] = arr[i - 1];
                    }
                    arr[0] = false;
                    break;

                case 4:
                    for(int i = 0; i < 19 ; i++) {
                        arr[i] = arr[i + 1];
                    }
                    arr[19] = false;
                    break;
            }
        }

        trainsHistory.add(trains.get(0));
        for (int k = 1; k < trains.size(); k++) {
            boolean[] train = trains.get(k);
            boolean flag = false;

            for (int i = 0; i < trainsHistory.size(); i++) {
                boolean[] history = trainsHistory.get(i);
                int cnt = 0;

                for (int j = 0; j < 20; j++) {
                    if (history[j] == train[j]) {
                        cnt += 1;
                    }
                }

                if (cnt == 20) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                result += 1;
                trainsHistory.add(train);
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}