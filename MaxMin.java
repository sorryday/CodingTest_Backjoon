import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class MaxMin 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int cnt = Integer.parseInt(br.readLine());
        int[] num = new int[cnt];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < cnt; i++)
        {
            num[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        Arrays.sort(num);   // 배열을 오름차순으로 정렬해주는 함수

        bw.write(num[0] + " " + num[num.length - 1]);
        bw.flush();
        bw.close();
    }    
}
