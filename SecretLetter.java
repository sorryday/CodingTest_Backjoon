import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SecretLetter {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> map = new HashMap<>();
        map.put("A", "000000");
        map.put("B", "001111");
        map.put("C", "010011");
        map.put("D", "011100");
        map.put("E", "100110");
        map.put("F", "101001");
        map.put("G", "110101");
        map.put("H", "111010");

        StringBuffer sb = new StringBuffer();

        String input = br.readLine();
        String numArrInput = br.readLine();

        for (int i = 0; i < numArrInput.length(); i += 6) {
            String sub = numArrInput.substring(i, i + 6);

            if (map.get("A").equals(sub) || isCheck(sub, map.get("A"))) {
                sb.append("A");
            } else if (map.get("B").equals(sub) || isCheck(sub, map.get("B"))) {
                sb.append("B");
            } else if (map.get("C").equals(sub) || isCheck(sub, map.get("C"))) {
                sb.append("C");
            } else if (map.get("D").equals(sub) || isCheck(sub, map.get("D"))) {
                sb.append("D");
            } else if (map.get("E").equals(sub) || isCheck(sub, map.get("E"))) {
                sb.append("E");
            } else if (map.get("F").equals(sub) || isCheck(sub, map.get("F"))) {
                sb.append("F");
            } else if (map.get("G").equals(sub) || isCheck(sub, map.get("G"))) {
                sb.append("G");
            } else if (map.get("H").equals(sub) || isCheck(sub, map.get("H"))) {
                sb.append("H");
            } else {
                sb = new StringBuffer();
                sb.append(i / 6 + 1);
                break;
            }
        }
        System.out.println(sb.toString());
    }

    static boolean isCheck(String sub, String numArrInput) {
        int cnt = 0;
        for (int i = 0; i < sub.length(); i++) {
            if (sub.charAt(i) != numArrInput.charAt(i)) {
                cnt++;
            }
        }

        if (cnt == 1) {
            return true;
        }
        else {
            return false;
        }
    }
}

