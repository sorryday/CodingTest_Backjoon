import java.io.*;
import java.util.ArrayList;

public class stick {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        ArrayList<Integer> stick = new ArrayList<Integer>();
        stick.add(64);

        if(x == 64) {
            bw.write("1");
        }

        else { 
            while(true) {
                int temp = 0;
                int cnt = 0;
    
                for(int i = 0; i < stick.size(); i++) {
                    temp += stick.get(i);
                }
    
                if(x < temp) {
                    int t2 = stick.get(stick.size() - 1) / 2;
                    stick.remove(stick.size() - 1);
    
                    stick.add(t2);
                    stick.add(t2);
    
                    int t3 = stick.remove(stick.size() - 1);
                    int t4 = 0;
    
                    for(int i = 0; i < stick.size(); i++) {
                        cnt += 1;
                        t4 += stick.get(i);
                    }
    
                    if(t4 > x) {
                        continue;
                    }
    
                    else if (t4 < x) {
                        stick.add(t3);
                        continue;
                    }
    
                    else if (t4 == x){
                        bw.write(Integer.toString(cnt));
                        break;
                    }
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}