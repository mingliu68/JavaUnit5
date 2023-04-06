import java.util.Iterator;
import java.util.LinkedList;


// You will be given two linked lists in “reverse-digit” format. 
// For example, the number 123 would be represented in a linked list 
// like this: 3 → 2 → 1 You should return the sum of these two numbers 
// in the same “reverse-digit” format. For 123 + 456, this should 
// return 579, in the form of a linked list like this: 9 → 7 → 5.

// What is the runtime of this function?


public class SumTwoLinkedList {
    public static void main(String[] args) {
        int num1 = 123;
        int num2 = 456;
        int num3 = 98765;
        int num4 = 789;

        printList(getLinkedListSum(createLinkedList(num2), createLinkedList(num4)));
        // printList(createLinkedList(num4));
    }

    public static LinkedList<Integer> getLinkedListSum(LinkedList<Integer> a, LinkedList<Integer> b) {
        int sum = getNum(a) + getNum(b);
        
        return createLinkedList(sum);
    }

    public static int getNum(LinkedList<Integer> list) {
        int num = 0; 
        int multiplier = 1;
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            num = iterator.next() * multiplier + num;
            multiplier *= 10;
        }
        return num;
    }

    // public static LinkedList<Integer> getLinkedListSum(LinkedList<Integer> a, LinkedList<Integer> b) {
    //     LinkedList<Integer> result = new LinkedList<>();

    //     Iterator<Integer> aRev = a.descendingIterator();
    //     Iterator<Integer> bRev = b.descendingIterator();
    //     boolean carryover = false;
        
        
    //     while(aRev.hasNext() && bRev.hasNext()) {
    //         int digitSum = aRev.next() + bRev.next() + (carryover == true ? 1 : 0);
    //         result.addFirst(digitSum % 10);
    //         carryover = digitSum > 9 ? true : false;
    //     }
    //     if(aRev.hasNext()) {
    //         addRemainingList(result, aRev, carryover);
    //     } else if(bRev.hasNext()){
    //         addRemainingList(result, bRev, carryover);
    //     } else if(carryover) {
    //         result.addFirst(1);
    //     }
        
        
    //     return result;
    // }

    // public static void addRemainingList(LinkedList<Integer> list, Iterator<Integer> iterator, Boolean carryover) {
    //     while(iterator.hasNext()) {
    //         int next = iterator.next() + (carryover == true ? 1 : 0);

    //         list.addFirst(next % 10);
    //         carryover = next > 9 ? true : false;
    //     }
    //     if(carryover) {
    //         list.addFirst(1);
    //     }
    // }

    public static LinkedList<Integer> createLinkedList(int num) {
        
        LinkedList<Integer> linkedList = new LinkedList<>();

        while(num > 0) {
            linkedList.add(num % 10);
            num = num / 10;
        }
        // System.out.println(linkedList);
        return linkedList;
    }

    public static void printList(LinkedList<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
        }
    }
}
