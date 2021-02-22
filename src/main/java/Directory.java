import java.util.ArrayList;
import java.util.stream.Collectors;

public class Directory {
    private static ArrayList<String> list = new ArrayList<String>();
    //simple sort, O(n^2)
    private static ArrayList<String> bubbleSort(ArrayList<String> al)
    {
        //outer loop
        for(int i = 0; i < al.size()-1; i++)
        {
            //inner loop
            for(int j = i+1; j < al.size(); j++)
            {
                //only swaps i and j when i > j
                if(al.get(i).compareTo(al.get(j)) > 0)
                {
                    String swap = al.get(j);

                    al.set(j, al.get(i));
                    al.set(i, swap);
                }
            }
        }
        return al;
    }
    public static void returnElements()
    {
        //need to use sorting algo (Bubble Sort)
        //list = (ArrayList<String>) list.stream().sorted().collect(Collectors.toList());
        list = bubbleSort(list);
        System.out.println(list);
        System.out.println("\n");
    }
    public static void addFile(String name)
    {
        //adds the file to arraylist, converting to lowercase and outputs a confirmation message
        if(!list.contains(name.toLowerCase()))
        {
            list.add(name.toLowerCase());
            System.out.println("\n" + name.toLowerCase() + " was added to the directory\n");
        }
        else System.out.println("\nError: File Already Exists\n");
    }
    public static void deleteFile(String name)
    {
        name = name.toLowerCase();
        if(list.contains(name))
        {
            System.out.println("\n" + name + " was removed from the directory\n");
            list.remove(name);
        }
        else
            System.out.println("\nError: File not Found\n");
    }
}
