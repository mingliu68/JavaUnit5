import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums1 = {2, 1, 4, 3, 6, 5, 7, 10, 9};
        int[] nums2 = {2, 1, 4, 3, 6, 5, 7, 8, 10, 11};
        System.out.println(findMissingNumber_N(nums1, 10));
        System.out.println(findMissingNumber_N(nums2, 11));
 
        System.out.println(findMissingNumber_NLOGN(nums1, 10));
        System.out.println(findMissingNumber_NLOGN(nums2, 11));

        System.out.println(findMissingNumber_N_1(nums1, 10));
        System.out.println(findMissingNumber_N_1(nums2, 11));
    }

    public static int findMissingNumber_N(int[] nums, int maxNum) {
        // Solving in O(n) time, reducing runtime

        Integer[] orderedNums = new Integer[maxNum];
        // O(n)
        for(int i = 0; i < nums.length; i++) {
            orderedNums[nums[i] - 1] = nums[i];
        }
        List<Integer> numsList = new ArrayList<>(Arrays.asList(orderedNums));
        
        // O(n)
        int result = numsList.contains(null) ? numsList.indexOf(null) + 1 : 0;

        return result;
    }

    public static int findMissingNumber_NLOGN(int[] nums, int maxNum) {
        // solving without using additional memory usage
        
        // java sort function O(n log n)
        Arrays.sort(nums);
        if(maxNum != nums[nums.length - 1]) return maxNum;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - 1 != nums[i-1]) return nums[i] - 1;
        }

        return 0;
    }

    public static int findMissingNumber_N_1(int[] nums, int maxNum) {
        // solve in O(n) runtime and O(1) runspace
        int fullSum = maxNum % 2 == 0 ? (int)((double)((maxNum / 2) + 0.5) * maxNum) : (int)((double)((maxNum / 2) + 1) * maxNum);
        // System.out.println(fullSum);
        for(int num: nums) {
            fullSum -= num;
        }
        
        return fullSum;
    }
}
