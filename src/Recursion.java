import java.util.ArrayList;
import java.util.List;

// Find the index of an item in a list using recursion.

// Implement a function that takes in an item and an array of items, 
// and returns the 0-based index of a sought item: >>> recursive_search(“hey”, [“hey”, “there”, “you”]) 0

// If the item isn’t in the list, return -1: >>> recursive_search(“porcupine”, [“hey”, “there”, “you”]) -1

// Important: Solve this problem only with recursion—you cannot use a for or while loop in your solution!

public class Recursion {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("hey");
        list1.add("there");
        list1.add("you");
        List<String> list2 = new ArrayList<>();
        list2.add("dog");
        list2.add("cat");
        list2.add("bird");
        list2.add("monkey");
        list2.add("horse");
        System.out.println(recursiveSearch(list1, "you"));
        System.out.println(recursiveSearch(list1, "porcupine"));
        System.out.println(recursiveSearch(list2, "you"));
        System.out.println(recursiveSearch(list2, "porcupine"));
        System.out.println(recursiveSearch(list2, "monkey"));
        
    }   

    public static int recursiveSearch(List<String> list, String item) {
        if(list.size() == 0 || list.size() == 1 && list.get(0) != item) {
            return -1;
        } 
        if(list.get(0) == item) {
            return 0;
        } else if(list.size() > 1) {
            List<String> subList = list.subList(1, list.size());
            int result = recursiveSearch(subList, item);
            if(result != -1) {
                result++;
            } 
            return result;
        }
        return -1;    

    }

}
