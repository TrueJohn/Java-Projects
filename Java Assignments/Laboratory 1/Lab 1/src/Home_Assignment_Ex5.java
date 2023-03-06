public class Home_Assignment_Ex5
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

    public static int lcm(int a,int b)
    {
        return (a/gcd(a,b))*b;
    }

    public static void main(String[] args)
    {
        //5. Write a Java program that prints the smallest common multiple of two integer numbers
        //given as command-line parameters.

        if(args.length==2)
        {
            System.out.print("The elements:\n");
            for (String arg : args)
                System.out.print(arg+" ");


            int a= Integer.parseInt(args[0]),b= Integer.parseInt(args[1]);

            System.out.print("\nThe lcm of "+args[0]+" and "+args[1] +" is :");
            System.out.print(lcm(a,b));

        }
        else
            System.out.print("Please insert just 2 numbers");

    }
}
