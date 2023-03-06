public class Home_Assignment_Ex4
{

    public static int gcd(int a,int b)
    {
        while(a!=b)
        {
            if(a>b)
                a=a-b;
            else
                b=b-a;
        }
        return a;
    }

    public static void main(String[] args) {

    //4. Write a Java program that prints the greatest common divisor of two integer numbers
        //given as command-line parameters.

        if(args.length==2)
        {
            System.out.print("The elements:\n");
            for (String arg : args)
                System.out.print(arg+" ");


           int a= Integer.parseInt(args[0]),b= Integer.parseInt(args[1]);

           System.out.print("\nThe gcd is :");
           System.out.print(gcd(a,b));

        }
        else
            System.out.print("Please insert just 2 numbers");


    }
}
