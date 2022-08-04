import java.io.*;
import java.util.*;

class Croatia_char {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        List<String> alpa = new ArrayList<>();
        alpa.add("c=");
        alpa.add("c-");
        alpa.add("dz=");
        alpa.add("d-");
        alpa.add("lj");
        alpa.add("nj");
        alpa.add("s=");
        alpa.add("z=");

        int result = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {

            String c = Character.toString(input.charAt(i));
            sb.append(c);
            String temp = sb.toString();

            for (int j = 0; j < alpa.size(); j++) {
                if (temp.contains(alpa.get(j))) {
                    String s = temp.replaceAll(alpa.get(j), " ");

                    sb = new StringBuilder();
                    sb.append(s);
                    result += 1;
                    break;
                }
            }
        }

        for (int i = 0; i < sb.length(); i++) {
            String t = sb.toString();
            if (t.charAt(i) != ' ') {
                result += 1;
            }
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}