import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class O_TW_TH_Plus {
    static int[] dp = new int[11];
	
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        dp[0] = 0;
        dp[1] = 1; 
        dp[2] = 2; 
        dp[3] = 4;

        for(int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(br.readLine());

            switch (num) {
                case 1:    
                    System.out.println(1); 
                break;

                case 2:  
                    System.out.println(2);   
                break;

                case 3:  
                    System.out.println(4);     
                break;
            
                default:
                    for(int k = 4; k < 11; k++) {
                        if(dp[k] == 0) {
                            dp[k] = dp[k - 1] + dp[k - 2] + dp[k - 3];
                        }
                    }
                    System.out.println(dp[num]);
                break;
            }  
        }
    }
}