import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static boolean isRunning = true;
    static boolean isInner = false;
    static String name = "";
    static String key = "";

    private static void welcomeScreen()
    {
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Welcome to LockedMe!");
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        System.out.println("    Created by:");
        System.out.println("   Ankur Kaushik");
        System.out.println("~~~~~~~~~~~~~~~~~~~~");
    }
    private static void enterName()
    {
        System.out.println("\nPlease enter your name below");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        String randString = "QWERTYUIOPASDFGHJKLZXCVBNM1234567890qwertyuiopasdfghjklzxcvbnm";
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < name.length(); i++)
            sb.append(randString.charAt((int)(Math.random()*randString.length())));

        key = sb.toString();
        System.out.println("\nYour Repository key is: " + key + "\n");
    }
    private static void dispOptions()
    {
        System.out.println("Select an option from the list below:");
        System.out.println(" 1. Return Files\n 2. User Interface Details (Add, Delete, Search)\n 3. Close Application");
    }
    private static boolean checkKey()
    {
        System.out.println("\nPlease enter your key below to proceed:");
        System.out.println(" Note: Keys are case sensitive\n");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().equals(key);
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
                        Directory.returnElements();
                        break;
                    case 2:
                        if(checkKey())
                        {
                            isInner = true;
                            System.out.println("\n///////");
                            System.out.println("Details");
                            System.out.println("///////\n");
                            innerLoop();
                        }
                        break;
                    case 3:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("\nPlease input a valid number between 1 and 3\n");
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
        System.out.println(" 1. Add File\n 2. Delete File\n 3. Search File\n 4. Edit File\n 5. View File\n 6. Return");
    }
    private static void innerLoop()
    {
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
                        try
                        {
                            System.out.println("\nEnter the name of the File you would like to add:");
                            System.out.println(" Note: Names will be converted to Lower Case");
                            sc = new Scanner(System.in);
                            Directory.addFile(sc.nextLine());
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Please input a valid name in the form of a String");
                        }
                        break;
                    case 2:
                        try
                        {
                            System.out.println("\nEnter the name of the File you would like to delete:");
                            System.out.println(" Note: Names will be converted to Lower Case");
                            sc = new Scanner(System.in);
                            Directory.deleteFile(sc.nextLine());
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Please input a valid name in the form of a String type");
                        }
                        break;
                    case 3:
                        try
                        {
                            System.out.println("\nEnter the name of the File you would like to search:");
                            System.out.println(" Note: Names will be converted to Lower Case");
                            sc = new Scanner(System.in);
                            Directory.searchFile(sc.nextLine());
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Please input a valid name in the form of a String");
                        }
                        break;
                    case 4:
                        try
                        {
                            System.out.println("\nEnter the name of the File you would like to edit:");
                            System.out.println(" Note: File names will be converted to Lower Case");
                            sc = new Scanner(System.in);
                            String name = sc.nextLine();
                            System.out.println("\nEnter the text to be added to the file:\n");
                            sc = new Scanner(System.in);
                            Directory.editFile(name, sc.nextLine());
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Please input a String");
                        }
                        break;
                    case 5:
                        try
                        {
                            System.out.println("\nEnter the name of the File you would like to view:");
                            System.out.println(" Note: File names will be converted to Lower Case");
                            sc = new Scanner(System.in);
                            String name = sc.nextLine();
                            Directory.viewFile(name);
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Please input a String");
                        }
                        break;
                    case 6:
                        System.out.println("\n/////////");
                        System.out.println("Returning");
                        System.out.println("/////////\n");
                        isInner = false;
                        break;
                    default:
                        System.out.println("\nPlease input a valid number between 1 and 6\n");
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
        enterName();
        outerLoop();

    }
}
