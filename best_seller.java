import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class best_seller {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        HashMap<String,Integer> map = new HashMap<>();
        String str;

        for(int i = 0; i < N; i++){
            str = br.readLine();
            if(map.containsKey(str)){
                map.replace(str, map.get(str)+1);
            }
            else{
                map.put(str, 1);
            }
        }

        int max = 0;
        for(String a : map.keySet()){
            max = Math.max(max, map.get(a));
        }

        ArrayList<String> al = new ArrayList<>(map.keySet());
        Collections.sort(al);

        for(String a : al){
            if(map.get(a) == max){
                bw.write(a);
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}