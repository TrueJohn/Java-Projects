public class LabAssignment {

    public static void main(String[] args){


///Write a Java program that computes the sum of all the integers numbers given as command-line
//parameters.

        int sum=0;
        int i=0;
        System.out.print("The elements\n");
        while(i<args.length)
        {
            sum=sum+Integer.parseInt(args[i]);
            System.out.print(args[i]+' ');
            i++;
        }

        System.out.println("\nThe sum of the numbers is:");
        System.out.println(sum);


    }
}