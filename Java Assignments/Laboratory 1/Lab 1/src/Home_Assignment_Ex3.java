public class Home_Assignment_Ex3 {

    public static void main(String[] args)
    {
        ///3. Write a Java program that prints the minimum value from all the double numbers given
        //as command-line parameters.

        if(args.length>0)
        {
            System.out.print("The elements:\n");
            for (String arg : args)
                System.out.print(arg+" ");

            Double min = Double.parseDouble(args[0]);


            for (String arg : args) {
                if (Double.parseDouble(arg) < min)
                    min = Double.parseDouble(arg);

            }

            System.out.print("\n\nThe minimum value from all the double numbers given is: \n");
            System.out.print(min);

        }
        else
            System.out.print("There are no elements inserted");


    }


}
