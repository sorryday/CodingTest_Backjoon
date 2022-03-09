import java.util.Scanner;

public class rangePlus
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      
      int a1 = sc.nextInt();
      int a2 = sc.nextInt();

      int[] num = new int[1002];

      int result = 0;
      int cnt = 1;

      for(int i = 1; i <= 1000; i++)   // 배열을 1002까지 주고 1, 2, 2, 3, 3, 3, .. 이런식으로 배열에 넣기
      {
         for(int k = 0; k < i; k++)
         {
            if(cnt == 1001)
            {
               break;
            }
            num[cnt] = i;
            cnt++;
         } 
      }

      for(int k = a1; k <= a2; k++)
      {
         result += num[k];
      }

      System.out.println(result);
   }
}