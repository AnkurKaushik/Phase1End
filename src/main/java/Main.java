public class Main {
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
    public static void main(String[] args)
    {
        welcomeScreen();
        dispOptions();
    }
}
