//You are given two integer arrays nums1 and nums2, sorted in non-decreasing 
//order, and two integers m and n, representing the number of elements in nums1 and 
//nums2 respectively. 
//
// Merge nums1 and nums2 into a single array sorted in non-decreasing order. 
//
// The final sorted array should not be returned by the function, but instead 
//be stored inside the array nums1. To accommodate this, nums1 has a length of m + 
//n, where the first m elements denote the elements that should be merged, and the 
//last n elements are set to 0 and should be ignored. nums2 has a length of n. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//Output: [1,2,2,3,5,6]
//Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//The result of the merge is [1,2,2,3,5,6] with the underlined elements coming 
//from nums1.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [1], m = 1, nums2 = [], n = 0
//Output: [1]
//Explanation: The arrays we are merging are [1] and [].
//The result of the merge is [1].
// 
//
// Example 3: 
//
// 
//Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//Output: [1]
//Explanation: The arrays we are merging are [] and [1].
//The result of the merge is [1].
//Note that because m = 0, there are no elements in nums1. The 0 is only there 
//to ensure the merge result can fit in nums1.
// 
//
// 
// Constraints: 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -10⁹ <= nums1[i], nums2[j] <= 10⁹ 
// 
//
// 
// Follow up: Can you come up with an algorithm that runs in O(m + n) time? 
//
// Related TopicsArray | Two Pointers | Sorting 
//
// 👍 13865, 👎 1688bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.amy.leetcode._88;

import java.util.Arrays;

public class MergeSortedArray{
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        solution.merge(nums1,3, nums2, 3);
        // 打印新数组
        System.out.println("result: " + Arrays.toString(nums1));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = 0;
        int index2 = 0;
        // 先用迴圈
        while(index1 < nums1.length){
            if(n==0 || index2== nums2.length)
                break;
            int num1 = nums1[index1];
            // 取出nums2的值
            int num2 = nums2[index2];
//            System.out.println("index1="+index1+", num1="+num1);
//            System.out.println("index2="+index2+", num2="+num2);
//            System.out.println("m="+m+", n="+n);
            if(num2 < num1) {    // 將nums2的值插入nums1陣列中
                // nums1 = insertElement(nums1, num2, index1);

                offsetElements(nums1, m - index1, m);// nums1的值先往後偏移
                nums1[index1] = num2;// nums1當前的索引位置放入num2
                index2++;
                m++;
                n--;
            } else if (m == index1) {
                nums1[index1] = num2;// nums1當前的索引位置放入num2
                index2++;
                m++;
                n--;
            }

            // 打印新数组
//            System.out.println("New Array: " + Arrays.toString(nums1));
            index1++;
        }

    }

    void offsetElements(int[] nums1, int 偏移處理個數, int 被覆蓋的索引值){
        while(偏移處理個數 > 0){
            nums1[被覆蓋的索引值] = nums1[被覆蓋的索引值-1];
            偏移處理個數--;
            被覆蓋的索引值--;   // 從最後1個數字開始向右偏移
        }

    }

    private int[] insertElement(int[] originalArray, int newValue, int insertIndex){
        int[] newArray = new int[originalArray.length];

        // 将原始数组的前半部分复制到新数组中
        System.arraycopy(originalArray, 0, newArray, 0, insertIndex);
        // 插入新元素
        newArray[insertIndex] = newValue;
        // 原始数组的后半部分复制到新数组中
        System.arraycopy(originalArray, insertIndex, newArray, insertIndex+1, originalArray.length - (insertIndex+1));

        return newArray;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
