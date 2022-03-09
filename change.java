import java.io.*; 

public class change {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int money = Integer.parseInt(br.readLine());
        int R_money = 1000 - money;
        int cnt = 0;
        
        if(R_money >= 500) {
            cnt += (R_money / 500);
            R_money -= ((R_money / 500) * 500);
        }

        if(R_money >= 100) {
            cnt += (R_money / 100);
            R_money -= ((R_money / 100) * 100);
        }

        if(R_money >= 50) {
            cnt += (R_money / 50);
            R_money -= ((R_money / 50) * 50);
        }

        if(R_money >= 10) {
            cnt += (R_money / 10);
            R_money -= ((R_money / 10) * 10);
        }

        if(R_money >= 5) {
            cnt += (R_money / 5);
            R_money -= ((R_money / 5) * 5);
        }

        if(R_money >= 1) {
            cnt += (R_money / 1);
            R_money -= ((R_money / 1) * 1);
        }
        
        System.out.println(cnt);
    }
}