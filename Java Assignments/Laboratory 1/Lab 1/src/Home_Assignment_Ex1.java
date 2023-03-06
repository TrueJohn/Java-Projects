public class Home_Assignment_Ex1 {

    public static int prime(int nr)
    {
        if(nr<2)
            return 0;
        for(int i=2;i<=nr/2;i++)
            if(nr%i==0)
                return 0;
        return 1;
    }
    public static void main(String[] args){

///1. Write a Java program that prints the prime numbers among the integers numbers given
//as command-line parameters.



        if(args.length>0)
        {   System.out.print("The elements:\n");
                for (String arg : args)
                    System.out.print(arg+" ");
            System.out.println("\n1.The prime numbers among the given integers are:");

            int min = Integer.parseInt(args[0]);
            int max = Integer.parseInt(args[0]);

            for (String arg : args) {
                if (Integer.parseInt(arg) > max)
                    max = Integer.parseInt(arg);
                if (Integer.parseInt(arg) < min)
                    min = Integer.parseInt(arg);

            }
            for(int j=min;j<=max;j++)
            {
                if(prime(j)==1)
                {
                    System.out.print(j);
                    System.out.print(' ');
                }
            }

        }
        else
            System.out.print("There are no elements inserted");

    }




}
