import java.io.*;

public class bertrand {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            int num = Integer.parseInt(br.readLine());
            int cnt = 0;

            if(num == 0) {
                break;
            }

            else if(num == 1){
                System.out.println(1);
            }

            else {
                boolean[] num_A = new boolean[(num * 2) + 1];
                num_A[0] = true;
                num_A[1] = true;

                for(int i = 2; i <= Math.sqrt(num_A.length); i++) {
                    if(num_A[i]) {
                        continue;
                    }
                    for(int j = i * i; j < num_A.length; j += i) {
                        num_A[j] = true;
                    }
                }
                
                for(int i = num + 1; i < num * 2; i++) {
                    if(num_A[i] == false) {
                        cnt += 1;
                    }
                }

                System.out.println(cnt);
            }   
        }
        br.close();
    }
}
