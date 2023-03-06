public class Home_Assignment_Ex2
{
    public static void main(String[] args)
    {
///2. Write a Java program that prints the maximum value from all the double numbers given
//as command-line parameters.


        if(args.length>0)
        {
            System.out.print("The elements:\n");
            for (String arg : args)
                System.out.print(arg+" ");

            Double max = Double.parseDouble(args[0]);


            for (String arg : args) {
                if (Double.parseDouble(arg) > max)
                    max = Double.parseDouble(arg);

            }

            System.out.print("\n\nThe maximum value from all the double numbers given is: \n");
            System.out.print(max);

        }
        else
            System.out.print("There are no elements inserted");


    }




}
