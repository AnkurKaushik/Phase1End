import java.util.ArrayList;
import java.util.stream.Collectors;

//inner class for files
class file{
    String name;
    ArrayList<String> value = null;
    //default constructor
    file(){
        name = "";
        value = new ArrayList<>();
    }
    //secondary constructor
    file(String n){
        name = n;
        value = new ArrayList<>();
    }
    @Override
    public String toString(){
        return name;
    }
}

public class Directory {
    //private static ArrayList<String> list = new ArrayList<String>();
    private static ArrayList<file> fileList = new ArrayList<file>();
    //simple sort, O(n^2)
    private static ArrayList<file> bubbleSort(ArrayList<file> al)
    {
        //outer loop
        for(int i = 0; i < al.size()-1; i++)
        {
            //inner loop
            for(int j = i+1; j < al.size(); j++)
            {
                //only swaps i and j when i > j
                if(al.get(i).name.compareTo(al.get(j).name) > 0)
                {
                    file swap = al.get(j);

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
        //sort in ascending order
        fileList = bubbleSort(fileList);
        //print items
        System.out.println(fileList);
        System.out.println("\n");
    }
    public static boolean containsName(String name)
    {
        //simple search for name in list
        for(file f : fileList)
        {
            if (f.name.equals(name.toLowerCase()))
            {
                return true;
            }
        }
        return false;
    }
    public static void addFile(String name)
    {
        //name doesn't already exist
        if(!containsName(name.toLowerCase()))
        {
            //create new file object and add to list
            fileList.add(new file(name.toLowerCase()));
            System.out.println("\n" + name.toLowerCase() + " was added to the directory\n");
        }
        else System.out.println("\nError: File Already Exists\n");
    }
    public static void deleteFile(String name)
    {
        //set to lower for simplicity
        name = name.toLowerCase();
        //name found
        if(containsName(name))
        {
            //remove element and return so no concurrent modification
            System.out.println("\n" + name + " was removed from the directory\n");
            for(file f : fileList)
                if(f.name.equals(name))
                {
                    fileList.remove(f);
                    return;
                }
        }
        else
            System.out.println("\nError: File not Found\n");
    }
    private static int binarySearch(ArrayList<file> al, String search)
    {
        //create left and right vars
        int l = 0;
        int r = al.size()-1;
        //loop
        while (l <= r)
        {
            //set mid value
            int m = l + (r - 1) / 2;
            //compare mid with search
            int sol = search.compareTo(al.get(m).name);
            if (sol == 0)
                return m;
            if (sol < 0)
                r = m - 1;
            else l = m + 1;
        }
        //not found
        return -1;
    }
    public static void searchFile(String name)
    {
        //for simplicity, set to lower
        name = name.toLowerCase();
        //list must be sorted for binary search
        fileList = bubbleSort(fileList);
        //location stored, calls function
        int loc = binarySearch(fileList, name);
        if(loc > -1)
        {
            System.out.println("\n" + name + " was found in the directory at location: " + loc +"\n");
        }
        //equals -1, not found in list
        else
            System.out.println("\nError: File not Found\n");
    }
    public static void editFile(String name, String contents)
    {
        //searches whole list, if file is found then adds to file contents
        for(file f : fileList)
            if(f.name.equals(name))
            {
                f.value.add(contents);
                System.out.println("\nThe contents of " + name + " were updated");
                return;
            }
        //file not in list
        System.out.println("\nError: File not Found\n");
    }
    public static void viewFile(String name)
    {
        //searches whole list if file found then each line of contents is printed
        for (file f : fileList)
            if(f.name.equals(name))
            {
                System.out.println("\nThe contents of file: " + name + " are displayed below");
                f.value.forEach(System.out::println);
                return;
            }
        //file is not in list
        System.out.println("\nError: File not Found\n");
    }
}
