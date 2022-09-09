package implementation;

import java.io.*;

public class turtle {
    static int [] dx = {-1,0,1,0};
    static int [] dy = {0,1,0,-1};

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int i = 0;i < T; i++) {
            int minX = 0, minY = 0, maxX = 0, maxY = 0, dir = 0, nowX = 0, nowY = 0; //초기값 북쪽

            String command = br.readLine();

            for(int j = 0; j < command.length(); j++) {
                char c = command.charAt(j);

                if(c == 'F') {
                    nowX = nowX + dx[dir];
                    nowY = nowY + dy[dir];
                }
                else if(c == 'B') {
                    nowX = nowX - dx[dir];
                    nowY = nowY - dy[dir];
                }
                else if(c == 'L') {
                    if(dir == 0) {
                        dir = 3;
                    }
                    else {
                        dir -= 1;
                    }
                }
                else if(c == 'R') {
                    if(dir == 3) {
                        dir = 0;
                    }
                    else dir += 1;
                }

                minX = Math.min(minX, nowX);
                minY = Math.min(minY, nowY);
                maxX = Math.max(maxX, nowX);
                maxY = Math.max(maxY, nowY);
            }
            bw.write(Integer.toString((Math.abs(minX)+Math.abs(maxX))*(Math.abs(minY)+Math.abs(maxY))) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}