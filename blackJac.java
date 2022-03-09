import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class blackJac {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        
        int cnt = Integer.parseInt(st.nextToken());   // 주어지는 카드 개수
        int m = Integer.parseInt(st.nextToken());     // 딜러가 불러주는 수

        int result = 0;
        int temp = 0;

        int[] card = new int[cnt];  // 카드 개수 배열
        
        input = br.readLine();
        st= new StringTokenizer(input);
        for(int i = 0; i < cnt; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i <= card.length - 3; i++) {

            for(int j = i + 1; j <= card.length - 2; j++) {

                for(int k = j + 1; k <= card.length - 1; k++) {
                    temp = card[i] + card[j] + card[k];

                    if(temp <= m) {
                        result = Math.max(temp, result); 
                    }             
                }
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}