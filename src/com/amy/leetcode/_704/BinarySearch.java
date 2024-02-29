//Given an array of integers nums which is sorted in ascending order, and an 
//integer target, write a function to search target in nums. If target exists, then 
//return its index. Otherwise, return -1. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-1,0,3,5,9,12], target = 9
//Output: 4
//Explanation: 9 exists in nums and its index is 4
// 
//
// Example 2: 
//
// 
//Input: nums = [-1,0,3,5,9,12], target = 2
//Output: -1
//Explanation: 2 does not exist in nums so return -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁴ < nums[i], target < 10⁴ 
// All the integers in nums are unique. 
// nums is sorted in ascending order. 
// 
//
// Related TopicsArray | Binary Search 
//
// 👍 11453, 👎 234bug 反馈 | 使用指南 | 更多配套插件 
//
//
//
//


package com.amy.leetcode._704;
public class BinarySearch{
    public static void main(String[] args) {
        Solution solution = new BinarySearch().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        // 合理區間採用「左閉右閉」策略
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            if(left == right){
                if(nums[left] == target){
                    return left;
                }else{
                    return -1;
                }
            }

            int middle = (left+right)/2;
            if(nums[middle] < target){
                left = middle +1;
            }else if(nums[middle] > target){
                right = middle -1;
            }else{
                return middle;
            }
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
