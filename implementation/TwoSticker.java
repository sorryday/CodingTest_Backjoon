package implementation;

import java.io.*;
import java.util.*;

public class TwoSticker {
    private static class Sticker {
        int R = 0;
        int C = 0;

        public Sticker(int r, int c) {
            R = r;
            C = c;
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        List<Sticker> stickerList = new ArrayList<>();

        int stickerCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < stickerCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            stickerList.add(new Sticker(R, C));
        }

        int result = 0;
        int sum = 0;

        for (int i = 0; i < stickerList.size() - 1; i++) {
            Sticker stickerFirst = stickerList.get(i);
            for (int j = i + 1; j < stickerList.size(); j++) {
                Sticker stickerSecond = stickerList.get(j);

                if ((stickerFirst.R + stickerSecond.R) <= H && Math.max(stickerFirst.C , stickerSecond.C) <= W ||
                        (stickerFirst.R + stickerSecond.R) <= W && Math.max(stickerFirst.C, stickerSecond.C) <= H) {
                    sum = stickerFirst.R * stickerFirst.C + stickerSecond.R * stickerSecond.C;
                }

                else if ((stickerFirst.R + stickerSecond.C) <= H && Math.max(stickerFirst.C, stickerSecond.R) <= W ||
                        (stickerFirst.R + stickerSecond.C) <= W && Math.max(stickerFirst.C, stickerSecond.R) <= H) {
                    sum = stickerFirst.R * stickerFirst.C + stickerSecond.R * stickerSecond.C;
                }

                else if ((stickerFirst.C + stickerSecond.R) <= H && Math.max(stickerFirst.R, stickerSecond.C) <= W ||
                        (stickerFirst.C + stickerSecond.R) <= W && Math.max(stickerFirst.R, stickerSecond.C) <= H) {
                    sum = stickerFirst.R * stickerFirst.C + stickerSecond.R * stickerSecond.C;
                }

                else if ((stickerFirst.C + stickerSecond.C) <= H && Math.max(stickerFirst.R, stickerSecond.R) <= W ||
                        (stickerFirst.C + stickerSecond.C) <= W && Math.max(stickerFirst.R, stickerSecond.R) <= H) {
                    sum = stickerFirst.R * stickerFirst.C + stickerSecond.R * stickerSecond.C;
                }

                result = Math.max(result, sum);
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}