import java.util.Arrays;
import java.util.stream.IntStream;

// Choose one of the following to implement: Insertion Sort Quick Sort Merge Sort

// What sorting algorithms have the best runtime efficiency? What are the scenarios 
// for the best case, worst case, and average case runtime efficiency?


public class SortingAlgo {
    public static void main(String[] args) {
        
        int[] arr1 = {3, 7, 2, 5, 4};
        int[] arr2 = {1, 1, 1, 1, 1};
        int[] arr3 = {1, 9, -8, 2, 11, 98, -72, 27};
        int[] arr4 = {5};
        int[] arr5 = {10, 80, 30, 90, 40, 50, 70};
        
        // insertion sort
        // printArr(insertionSort(arr1));
        // printArr(insertionSort(arr2));
        // printArr(insertionSort(arr3));
        // printArr(insertionSort(arr4));
        // printArr(insertionSort(arr5));

        // printArr(quickSort(arr5));

        printArr(mergeSort(arr5));
    }

    public static int[] insertionSort(int[] arr) {
        // insertion sort, get min up to i and place it in it's correct position
        
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i-1]) {
                int compIndex = i-1;
                int self = i;
                while(compIndex >= 0 && arr[self] < arr[compIndex]) {
                    int temp = arr[compIndex];
                    arr[compIndex] = arr[self];
                    arr[self] = temp;
                    compIndex--;
                    self--;
                }
            }
        }

        return arr;
    }

    public static int[] quickSort(int[] arr) {
        // quick sort, get pivot, left and right pointer
        // initially set pivot to either left or right pointer 
        // comparing left and right pointer value and switch accordingly
        // move pivot along accordingly
        // get final pivot position / partition, 
        // every elements in the left of pivot is less than 

        if(arr.length <= 1) {
            return arr;
        }
        // get pivot and partition array
        int p = getPartition(arr);

        // get partitioned arrays
        int[] a = Arrays.copyOfRange(arr, 0, p);
        int[] b = Arrays.copyOfRange(arr, p, arr.length);
        
        int[] result = IntStream.concat(Arrays.stream(quickSort(a)), Arrays.stream(quickSort(b))).toArray();

        return result;
    }

    public static int getPartition(int[] arr) {
        // set the last elem as pivot, comparing the rest to the pivot
        // by the end of the iteration, everything on the left side of the pivot should be less than pivot 
        // and everything on the right side of the pivot should be greater than pivot
        
        // keeping one counter to keep track of the last smaller element index
        // loop thru array up to right before the pivot
        // comparing each element with pivot
        // if element is less or equal to pivot
        // increase counter by 1, swap array[counter] and array[looping_index]
        // if element is greater than pivot, then no action taken

        int lessVal = -1;

        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] <= arr[arr.length - 1]){
                lessVal++;
                int temp = arr[i];
                arr[i] = arr[lessVal];
                arr[lessVal] = temp;
            }
        }
        lessVal++;
        int temp = arr[lessVal];
        arr[lessVal] = arr[arr.length - 1];
        arr[arr.length - 1] = temp;
        // System.out.println(Arrays.toString(arr));

        return lessVal;
    }
    

    public static int[] mergeSort(int[] arr) {
        // merge sort, divide and conqur
        // split array into single element
        // then rejoin them sorted recursively
        // need helper function for sorting

        if(arr.length == 1) {
            return arr;
        }

        int[] a = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] b = Arrays.copyOfRange(arr, arr.length/2, arr.length);


        return mergeArrs(mergeSort(a), mergeSort(b));
    }

    public static int[] mergeArrs(int[] a, int[] b) {

        int[] result = new int[a.length + b.length];

        int indA = 0;
        int indB = 0;
        int index = 0;

        while(indA < a.length && indB < b.length) {
            if(a[indA] < b[indB]) {
                result[index] = a[indA];
                indA++;
            } else {
                result[index] = b[indB];
                indB++;
            }
            index++;
        }
        
        // add remaining a into result array
        while(indA < a.length) {
            result[index] = a[indA];
            indA++;
            index++;
        }

        // add remaining b into result array
        while(indB < b.length) {
            result[index] = b[indB];
            indB++;
            index++;
        }

        return result;
    }

    public static void printArr(int[] arr) {
        System.out.println();
        System.out.print("[");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i < arr.length - 1 ? ", " : ""));
        }
        System.out.print("]");
    }
}
