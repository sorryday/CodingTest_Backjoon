import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GCD_LCM
{
   public static void main(String[] args) throws IOException
   {  
      int num1 , num2 = 0;

      int Tnum1, Tnum2 = 0;
      int temp = 0;

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringTokenizer st = new StringTokenizer(br.readLine());

      num1 = Integer.parseInt(st.nextToken());
      num2 = Integer.parseInt(st.nextToken());
      br.close();

      Tnum1 = num1;
      Tnum2 = num2;

      if(num1 < num2) 
      {
         temp = num2;
         num2 = num1;
         num1 = temp;
      }

      while(num2 != 0)    // 최대 공약수 구하는 알고리즘 ( GCD, 단 num1 > num2 , 이때 num1의 값이 최대 공약수)
      {
         temp = num1 % num2;
         num1 = num2;
         num2 = temp;
      }

      System.out.println(num1);
      System.out.println(Tnum1 * Tnum2 / num1);   // 최소공배수 구하는 알고리즘( LCM , 단 num1 > num2 )
   }
}