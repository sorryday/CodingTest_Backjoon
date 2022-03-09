import java.util.Scanner;

public class decimalPlus 
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      
      int start = sc.nextInt();
      int end = sc.nextInt();

      int cnt = 0;
      int result = 0;
      int first = 0;

      for(int i = start; i <= end; i++)
      {
         int temp = 0;
         for(int k = 1; k <= i; k++)
         {
            if(i % k == 0)
            {
               temp += 1;
            }
         } 

         if(temp == 2)
         {
            result += i;
            cnt += 1;

            if(cnt == 1)
            {
               first = i;
            }
         }
      }

      if(cnt == 0)
      {
         System.out.println(-1);
         System.exit(0);
      }
      else
      {
         System.out.println(result);
         System.out.println(first);
         System.exit(0);
      }
   }
}