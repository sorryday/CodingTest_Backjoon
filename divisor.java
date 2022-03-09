import java.util.ArrayList;
import java.util.Scanner;

/**
 * divisor (약수 구하기)
 */
class divisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt(); 
        int num2 = sc.nextInt();

        ArrayList divisor = new ArrayList<Integer>();  

        for(int i = 1; i <= num1; i++)
        {
            if(num1 % i == 0)
            {
                divisor.add(i);  
            } 
        }
        
        if(divisor.size() < num2)
        {
            System.out.println(0);
        }  
        else
        {
            System.out.println(divisor.get(num2 - 1));
        }
    }
}