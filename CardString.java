import java.io.*;

public class CardString {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int length = Integer.parseInt(br.readLine());
            String[] inputString = br.readLine().split(" ");
            StringBuffer sb = new StringBuffer();

            sb.append(inputString[0]);
            for (int i = 1; i < inputString.length; i++) {
                String bufferString = sb.toString();
                if (bufferString.charAt(0) - '0' >= inputString[i].charAt(0) - '0') {
                    sb.insert(0, inputString[i]);
                } else {
                    sb.append(inputString[i]);
                }
            }

            bw.write(sb.toString() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}