//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have leading
// zeros. 
// 
// Related Topics Linked List Math Recursion 
// ๐ 15826 ๐ 3408


package com.amy.leetcode._2;

public class AddTwoNumbers{
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(8, new ListNode(7, new ListNode(6, new ListNode(9))));
        ListNode result = solution.addTwoNumbers(l1, l2);
        System.out.println(result);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // ่ฏพ็จ A -ใ ้พ่กจ -> ๅบ็ก็ฏ
        ListNode result = null;
        ListNode curr = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int total = x + y + carry;
//            curr.next = new ListNode(total % 10);
            if(curr == null){   // ็ฌฌไธๆฌก้ฒๅฅ่ฟดๅ
                curr = result = new ListNode(total % 10);
            }else{
                curr = curr.next = new ListNode(total % 10);
            }
            carry = total / 10;
            // ๅฆๆL1/L2็บnull, ่กจ็คบ็ถๅ็ฏ้ป็ๆฏ้่กจ็ๆๅพ1ๅๆธๅญ
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry != 0) curr.next = new ListNode(carry); // ็ตๆ่ฟดๅๅพๆชขๆฅๆฏๅฆ้้่ฆๅ้ฒ1ไฝ
        return result;
    }
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        // ่ฏพ็จ A -ใ ้พ่กจ -> ๅบ็ก็ฏ
//        ListNode dummy = new ListNode();
//        ListNode curr = dummy;
//        int carry = 0;
//        while (l1 != null || l2 != null) {
//            int x = l1 == null ? 0 : l1.val;
//            int y = l2 == null ? 0 : l2.val;
//
//            int total = x + y + carry;
//            curr.next = new ListNode(total % 10);
//            // bug ไฟฎๅค๏ผ่ง้ขไธญๅฟไบ็งปๅจ curr ๆ้ไบ
//            curr = curr.next;
//            carry = total / 10;
//
//            if (l1 != null) l1 = l1.next;
//            if (l2 != null) l2 = l2.next;
//        }
//        if (carry != 0) curr.next = new ListNode(carry);
//        return dummy.next;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
