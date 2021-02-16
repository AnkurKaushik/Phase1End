import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static boolean isRunning = true;

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
    private static void innerLoop()
    {
        System.out.println("Inner Loop");
    }
    public static void main(String[] args)
    {
        welcomeScreen();
        outerLoop();

    }
}
