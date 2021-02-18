import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static boolean isRunning = true;
    static boolean isInner = false;

    private static void welcomeScreen()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Welcome to LockedMe!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        System.out.println("    Created by:");
        System.out.println("   Ankur Kaushik");
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
    }
    private static void dispOptions()
    {
        System.out.println("Select an option from the list below:");
        System.out.println(" 1. Return Files\n 2. User Interface Details (Add, Delete, Search)\n 3. Close Application");
    }
    private static void outerLoop()
    {
        do
        {
            dispOptions();
            Scanner sc = new Scanner(System.in);
            int userChoice = -1;
            try
            {
                userChoice = sc.nextInt();
                switch (userChoice)
                {
                    case 1:
                        System.out.println("The files in your repository are listed below:\n\n");
                        break;
                    case 2:
                        isInner = true;
                        innerLoop();
                        break;
                    case 3:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Please input a valid number in the following format (ex:) 2");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("\nPlease input a valid number in the following format (ex:) 2\n");
            }
        } while (isRunning);
    }
    private static void innerOptions()
    {
        System.out.println("Select an option from the list below:");
        System.out.println(" 1. Add File\n 2. Delete File\n 3. Search File\n 4. Return");
    }
    private static void innerLoop()
    {
        System.out.println("");
        do
        {
            innerOptions();
            Scanner sc = new Scanner(System.in);
            int innerChoice = -1;
            try
            {
                innerChoice = sc.nextInt();
                switch (innerChoice)
                {
                    case 1:
                        System.out.println("Add File");
                        break;
                    case 2:
                        System.out.println("Delete File");
                        break;
                    case 3:
                        System.out.println("Search File");
                        break;
                    case 4:
                        System.out.println("\n/////////");
                        System.out.println("Returning");
                        System.out.println("/////////\n");
                        isInner = false;
                        break;
                    default:
                        System.out.println("Please input a valid number in the following format (ex:) 2");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("\nPlease input a valid number in the following format (ex:) 2\n");
            }
        }
        while (isInner);
    }
    public static void main(String[] args)
    {
        welcomeScreen();
        outerLoop();

    }
}
