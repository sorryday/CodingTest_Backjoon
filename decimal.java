import java.util.Scanner;

public class decimal
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      int testCase = sc.nextInt();

      int[] arr = new int[testCase];
      int cnt = 0;

      for(int j = 0; j < testCase; j++)
      {
         arr[j] = sc.nextInt();
      }
         
      for(int i = 0; i < testCase; i++)
      {
         int temp = 0;
         if(arr[i] == 1)
         {
            continue;
         }

         for(int k = 1; k <= arr[i]; k++)
         {
            if(arr[i] % k == 0)
            {
               temp += 1;
            }
         }

         if(temp == 2)
         {
            cnt += 1;
         }
      }
         
      System.out.println(cnt);
   }
}