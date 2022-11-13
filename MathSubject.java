import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MathSubject {
    static Queue<String> numberQueue = new LinkedList<>();
    static List<Long> numList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = "";
        String regex = "([\\d]+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher;

        int N = Integer.parseInt(br.readLine());
        ArrayList<BigDecimal> arr = new ArrayList<BigDecimal>();

        for (int i = 0; i < N; i++) {
            str = br.readLine();
            matcher = pattern.matcher(str);
            while(matcher.find()) {
                arr.add(new BigDecimal(matcher.group()));
            }
        }

        arr.sort(Comparator.naturalOrder());
        for (BigDecimal val : arr) {
            bw.write(val + "");
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}