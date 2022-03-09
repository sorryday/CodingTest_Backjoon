import java.io.IOException;
import java.util.Scanner;

public class train 
{    public static void main(String[] args) throws IOException
    {
        int[] inPeople = new int[10];
        int[] outPeople = new int[10];
        
        int people = 0;
        int most = 0;
        
        Scanner sc = new Scanner(System.in);  

        for(int i = 0; i < 10; i++)
        {
            outPeople[i] = sc.nextInt();
            inPeople[i] = sc.nextInt();
        }

        for(int k = 0; k < 9; k++)
        {
            people += inPeople[k];
            if(people > most)
            {
                most = people;
            }

            people -= outPeople[k + 1];
        }

        System.out.println(most);
    }
}
