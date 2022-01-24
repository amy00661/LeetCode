//Given a string s, find the length of the longest substring without repeating c
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table String Sliding Window 
// 👍 20626 👎 935


package com.amy.leetcode._3;

import java.util.ArrayList;
import java.util.List;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
//        int max = solution.lengthOfLongestSubstring(" q werq");
//        int max = solution.lengthOfLongestSubstring(" _a_ bc ");
//        System.out.println(max);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        List<String> collections = new ArrayList();
//        int currSize = 0;
        int max = 0;
        for(int i=0 ; i<s.length(); i++){
            String currStr = Character.toString(s.charAt(i));
            if(collections.contains(currStr)){
                if(collections.size() > max){
                    max = collections.size();
                }

                /** 取得此字元第1次出現在collections的index,
                 * 將其與當前字元之間的所有字元全部放入新的collections裡面
                 */
                int first = collections.indexOf(currStr);
                List<String> newList = new ArrayList<>();
                for(int idx=(first+1) ; idx < collections.size(); idx++){
                    newList.add(collections.get(idx));
                }
                newList.add(currStr);
                collections = newList;
                continue;
            }
            collections.add(currStr);
        }

        if(collections.size() > max){
            max = collections.size();
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
