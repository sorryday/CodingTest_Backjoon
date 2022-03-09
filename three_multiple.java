import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class three_multiple { 
    static int count = 0;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int hap = Integer.parseInt(Plus(num));
        System.out.println(count);

        if(hap % 3 == 0){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    public static String Plus(String S_hap){
        int temp = 0;
        char c_temp;

        if(S_hap.length() > 1) {
                for(int i = 0; i < S_hap.length(); i++) {
                    c_temp = S_hap.charAt(i);
                    temp += Integer.parseInt(String.valueOf(c_temp));
                }

                count++;
                return Plus(Integer.toString(temp));
        }
        else {
            return S_hap;
        }
    }
}


