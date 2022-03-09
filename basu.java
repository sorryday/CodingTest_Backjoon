import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class basu {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;

        int cnt = Integer.parseInt(br.readLine());
        for(int i = 0; i < cnt; i++) {
            int room_cnt = Integer.parseInt(br.readLine());
            boolean[] room = new boolean[room_cnt + 1];

            for(int k = 1; k < room.length; k++) {  // 1라운드 : 문 다 열음
                room[k] = true;
            }

            for(int j = 2; j < room.length; j++) {
                for(int t = j; t < room.length; t += j) {
                    if(room[t] == true) {
                        room[t] = false;
                    }

                    else if(room[t] == false) {
                        room[t] = true;
                    }
                }
            }

            for(int q = 1; q < room.length; q++) {
                if(room[q] == true) {
                    result += 1;
                }
            }

            System.out.println(result);
            result = 0;
        }

        br.close();
    }
}