import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Line { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        LinkedList<String> num = new LinkedList<String>();      // 학생 번호
        int student_num = Integer.parseInt(br.readLine()); // 학생수
        String index;         // 번호표

        String S_num = br.readLine();
        StringTokenizer st = new StringTokenizer(S_num);
        for(int i = 0; i < student_num; i++) {
            index = st.nextToken();
            int temp = Integer.parseInt(index);

            if(temp > 0) {
                num.add(i - temp, Integer.toString(i + 1));
            }

            else {
                num.add(Integer.toString(i + 1));
            }
        }

        for(int i = 0; i < num.size(); i++) {
            System.out.print(num.get(i) + " ");
        }
    }
}