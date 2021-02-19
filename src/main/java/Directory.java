import java.util.ArrayList;

public class Directory {
    private static ArrayList<String> list = new ArrayList<String>();
    public static void returnElements()
    {
        System.out.println(list);
        System.out.println("\n");
    }
    public static void addFile(String name)
    {
        list.add(name.toLowerCase());
        System.out.println("\n" + name.toLowerCase() + " was added to the directory\n");
    }
}
